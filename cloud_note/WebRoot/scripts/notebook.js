function loadNoteBooks(){
	
	$.ajax({
        url:"http://localhost:8088/cloud_note/notebook/loadbooks.do",
        type:"post",
        data:{"userId":userId},
        dataType:"json",
        success:function(result){
           if(result.status==0){
               var books = result.data;//笔记本json集合信息
               //循环集合生成笔记本li列表
               for(var i=0;i<books.length;i++){
                   //获取每个笔记本元素的笔记本名称
                   var bookName = books[i].cn_notebook_name;
                   //获取每个笔记本元素的笔记本ID
                   var bookId = books[i].cn_notebook_id;
                   //拼li
                   var s_li = '<li class="online"><a >';
					 s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
					 s_li += '</i>'+bookName+'</a></li>';
					 //将s_li字符串转成Jquery对象，藏bookId
					 var $li = $(s_li);
					 $li.data("bookId",bookId);
					 //将li添加到笔记本ul中
					 $("#book_list").append($li);
               
               }     
           }
        }
     });
	
};
//弹出添加笔记本对话框
function showAddBookWindow(){
    $(".opacity_bg").show();//显示背景
    $("#can").load("alert/alert_notebook.html");
};
//关闭对话框
function closewindow(){
    $("#can").empty();
    $(".opacity_bg").hide();
  };

//确认创建笔记本
function sureAddBook(){
      //获取笔记本名
      var bookName = $("#input_notebook").val().trim();
      //检查笔记本名是否为空
      //发送Ajax
      $.ajax({
         url:"http://localhost:8088/cloud_note/notebook/add.do",
         type:"post",
         data:{"bookName":bookName,"userId":userId},
         dataType:"json",
         success:function(result){
            if(result.status==0){//关闭对话框
                 closewindow();
                 //添加一个笔记li
                 var bookId = result.data;//返回的bookId
                 var s_li = '<li class="online"><a >';
				 s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
				 s_li += '</i>'+bookName+'</a></li>';
				 //将s_li字符串转成Jquery对象，藏bookId
				 var $li = $(s_li);
				 $li.data("bookId",bookId);
				 //将li添加到笔记本列表区
				 $("#book_list").prepend($li);
            }
         
         },
         error:function(){
            alert("创建笔记失败");
         }
         
      });
   };

function loadReplaySelect(){

   //加载笔记本信息，生成下拉单选项
   $.ajax({
      url:"http://localhost:8088/cloud_note/notebook/loadbooks.do",
      type:"post",
      data:{"userId":userId},
      dataType:"json",
      success:function(result){
        var books = result.data;
        //循环生成option
        for(var i=0;i<books.length;i++){
           //获取每个笔记本元素的笔记本名称
            var bookName = books[i].cn_notebook_name;
            //获取每个笔记本元素的笔记本ID
            var bookId = books[i].cn_notebook_id;
            //拼option
            var s_opt = '<option value="'+bookId+'">'+bookName+'</option>';
            //将option添加到replaySelect
            $("#replaySelect").append(s_opt);
        }
      }
   });

};






