 $(function(){
    $("#regist_button").click(function(){
//       //清除原有的提示信息
//       $("#regist_username").val("");
//       $("#nickname").val("");
//       $("#regist_password").val("");
//       $("#final_password").val("");
       //获取表单信息
       var name = $("#regist_username").val().trim();
       var nick = $("#nickname").val().trim();
       var password = $("#regist_password").val().trim();
       var final_password = $("#final_password").val().trim();
       //检查表单信息格式
       //发送Ajax
       $.ajax({
          url:"http://localhost:8088/cloud_note/user/regist.do",
          type:"post",
          data:{"name":name,"password":password,"nickname":nick},
          dataType:"json",
          success:function(result){
            if(result.status==0){
               alert(result.msg);
               $("#back").click();//触发返回按钮
               
            }else if(result.status==1){//占用
               $("#warning_1 span").html(result.msg);
               $("#warning_1").show();//显示div消息区
            }
          },
          error:function(){
             alert("注册发生异常");
          }
       });
    
    });
  
  });
