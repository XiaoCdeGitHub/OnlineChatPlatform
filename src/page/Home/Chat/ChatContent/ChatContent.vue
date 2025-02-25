<template>
  <div class="chat-box">
    <div class="isempty" v-if="!showChatBox">
      <el-empty description="请先选择好友哦"></el-empty>
    </div>
    <!-- 二者总有一个不为空 -->
    <div v-if="showChatBox">
      <div class="chat-top-box">
        <div class="chat-name-box">{{chatPerson.name}}</div>
      </div>
      <div>
        <div>
          <div class="history" @click="getChatHistory" v-if="chatHistoryBtn">获取历史聊天记录</div>
        </div>
        <div class="chat-main-box">
          <chat-item :msg="item" v-for="(item,index) in messageList" :key="index"></chat-item>
        </div>
      </div>
      <div class="chat-input-box">
        <textarea name="" id="chat-input" cols="30" rows="2" ref="chatInput" @keydown.enter="sendMessage"></textarea>
        <div class="send-btn" @click="sendMessage">发送(Enter)</div>
      </div>
    </div>
  </div>
</template>

<script>
import ChatItem from "./ChatItem.vue";
export default {
  created(){
    this.chatHistoryBtn = true;
    /* let userInfo = this.$store.state.user.userMessage;
      console.log(userInfo);
      let obj = {
        sendUserName: userInfo.name,
        sendUserAvatar: userInfo.avatar,
        receiveUserId: this.$store.state.chat.chatUser.userId,
        sendUserId: userInfo.userId,
        sendContent: this.$refs.chatInput.value,
      };
      this.messageList.push(obj); */
    
  },
  mounted() {
    
    this. chatHistoryBtn = true;
    // console.log('测试一下这个', JSON.parse(sessionStorage.getItem("chatPerson")).userId != undefined);
    this.conectWebSocket();
    // console.log(this.chatPerson != undefined || this.chatPerson != null, 'showBox返回值')
//重新读取 不写的话会
    // if (sessionStorage.getItem("chatPerson")) {
    //   this.chatPerson = JSON.parse(sessionStorage.getItem("chatPerson"))
    //   console.log('重新读取this.chatPerson', this.chatPerson)
    // }
    console.log('chatPerson的返回值',this.chatPerson)
  },
  computed: {
    showChatBox() {
      // return this.$store.state.chat.chatUser.userId != undefined
      //第一次进入 vuex没值 st没值 点击后都有值
      //此时 因做到vuex和st同步更改的渲染 vuex可以同步 st不可以
      //key point：刷新后 vuex是没值的

      //a1
      // if (this.$store.state.chat.chatUser.userId != undefined ) {
      //   return true
      // }

      //a2
      if (this.chatPerson) {
        return true;
      }

    },
    getChatState() {
      return this.chatPerson.userId;
    },
    chatPerson() {
      console.log('计算了一次')
      // this.$store.state.chat.chatUser.name==undefined? chatPerson.name :this.$store.state.chat.chatUser.name
      if (this.$store.state.chat.chatUser.userId != undefined) {
        console.log('return this.$store.state.chat.chatUser')
        return this.$store.state.chat.chatUser
      } else if (JSON.parse(sessionStorage.getItem("chatPerson")) != null) {
        console.log('return JSON.parse(sessionStorage.getItem("chatPerson"))')
        return JSON.parse(sessionStorage.getItem("chatPerson"))
      } else {
        return false
      }
      
    }

  },
  components: {
    ChatItem,
  },
  watch: {
    getChatState(newName, oldName) {
      this.messageList = [];
      this.chatHistoryBtn = true;
    },
  },
  methods: {
    
    //控制
    conectWebSocket() {
      let nickname = this.currentUser.name;
      let that = this;
      if (nickname === "") {
        alert("登录成功！请完善个人信息！");
        this.$router.push("/info")
        return;
      }
      //判断当前浏览器是否支持WebSocket
      if ("WebSocket" in window) {
        this.websocket = new WebSocket(
          "ws://localhost:8080/websocket/" + nickname
        );
      } else {
        alert("Not support websocket");
      }
      //连接发生错误的回调方法
      this.websocket.onerror = function () {
        console.log("err");
      };
      //连接成功建立的回调方法
      this.websocket.onopen = function (event) {
        console.log(event);
      };
      //接收到消息的回调方法
      this.websocket.onmessage = function (event) {
        console.log('接收到消息的回调方法',event);
        let message = JSON.parse(event.data);
        if (message.receiveUserId == JSON.parse(sessionStorage.getItem("currentUser")).userId) {
          // console.log("this.websocket.onmessage的messageId", message.receiveUserId)
          that.messageList.push(message);
          that.$nextTick(() => {
            const chatMainBox = that.$el.querySelector('.chat-main-box');
            chatMainBox.scrollTop = chatMainBox.scrollHeight;
          });
          console.log("我是that.messageList啦啦啦啦啦",that.messageList);
        }
      };
      //连接关闭的回调方法
      this.websocket.onclose = function () {
        console.log("close");
      };
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function () {
        this.websocket.close();
      };
    },
    sendMessage() {
      let userInfo = JSON.parse(sessionStorage.getItem("currentUser"));
      console.log(userInfo,"我在发送信息");
      let obj = {
        sendUserName: userInfo.name,
        sendUserAvatar: userInfo.avatar,
        receiveUserId: this.chatPerson.userId,
        sendUserId: userInfo.userId,
        sendContent: this.$refs.chatInput.value,
      };
      this.websocket.send(JSON.stringify(obj));
      this.messageList.push(obj);
      this.$nextTick(() => {
        const chatMainBox = this.$el.querySelector('.chat-main-box');
        chatMainBox.scrollTop = chatMainBox.scrollHeight;
      });
      console.log(this.messageList);
      this.$refs.chatInput.value = "";
    },
    getChatHistory() {
      this.messageList =[]
      this.chatHistoryBtn = false;
      let sendUserId = this.currentUser.userId;
      let receiveUserId = this.chatPerson.userId;
      this.$api.chatApi.getChatHistory(sendUserId,receiveUserId).then((res) => {
      console.log(res);
     res.forEach(i => {
      let historyChatObj = {
  receiveUserId: i.receiveUserId,
  sendUserId: i.sendUserId,
  sendUserAvatar: i.sendUserAvatar,
  sendContent: i.sendContent,
  sendUserName: i.sendUserName
}
console.log("historyChatObj",historyChatObj);
      this.messageList.push(historyChatObj);
      });
        console.log(this.messageList);
        this.$nextTick(() => {
          // 获取聊天框的 DOM 元素
          const chatMainBox = this.$el.querySelector('.chat-main-box');
          // 将滚动条滚动到底部
          chatMainBox.scrollTop = chatMainBox.scrollHeight;
        });
    }).catch((err) => {
      console.log(err);
    });
    }
  },
  data() {
    return {
      websocket: null,
      messageList: [
        /* {
          sendUserName: "备胎一号",
          sendUserAvatar:
            "https://img2.woyaogexing.com/2020/10/09/222a2de17e87421285c352b050f2c47d!400x400.jpeg",
          sendUserId: "123456",
          toUserId:'6',
          sendContent: "嘤嘤嘤",
        }, */
      ],
      chatHistoryBtn: true,
      // chatPerson: this.changeChatPerson,
      currentUser: JSON.parse(sessionStorage.getItem("currentUser"))
    };
  },
};
</script>

<style lang="less" scoped>
.isempty {
  position: absolute;
  left: 42%;
  top: 150px;
}
.chat-box {
  position: relative;
  width: 660px;
  height: 700px;
}
.chat-top-box {
  width: 100%;
  height: 70px;
  background-color: #f5f5f5;
  border-bottom: 1px solid #e6e5e5;
  border-left: 1px solid #e6e5e5;
}
.chat-name-box {
  width: 450px;
  height: 70px;
  line-height: 70px;
  font-size: 22px;
  margin-left: 40px;
}
.chat-main-box {
  width: 100%;
  height: 468px;
  overflow-y: scroll;
  overflow-x: hidden;
}
.chat-input-box {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 160px;
  border-top: 1px solid #e6e5e5;
  #chat-input {
    margin-top: 20px;
    margin-left: 30px;
    width: 90%;
    font-size: 18px;
    height: 80px;
    background-color: transparent;
    border: none;
    outline: none;
    resize: none;
  }
  .send-btn {
    position: absolute;
    right: 40px;
    margin: 10px;
    width: 100px;
    height: 35px;
    background-color: #e9e9e9;
    text-align: center;
    line-height: 35px;
    color: #5fc160;
    border-radius: 5px;
  }
  
}.history{
    width: 100px;
    height: 18px;
    margin-left: auto;
    margin-right: auto;
    // background-color: red;
    color: rgb(2, 174, 243);
    font-size: 12px;
  }
</style>
