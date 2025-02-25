<template>
  <div style="display: flex">
    <chat-list></chat-list> 
    <chat-content></chat-content>
    
  </div>
</template>

<script>
import ChatList from "./ChatList/ChatList.vue";
import ChatContent from "./ChatContent/ChatContent.vue";
export default {
  components: {
    ChatList,
    ChatContent,
  },
  beforeRouteLeave(to, from, next) {
    // 清除 sessionStorage 目的是：清除上一次点击聊天列表选中用户后的缓存，以免下一次点击回来，还是该用户 
    // this.isRefresh = false;
    sessionStorage.removeItem("chatPerson");
    //清空vuex状态 使得子组件逻辑正确 不会因vuex在路由跳转后因有值渲染错误
    this.$store.commit("chat/changeUser", {});

    next();
  },
  // data(){
  //   return {
  //     isRefresh: true
  //   }
  // }
};
</script>

<style></style>
