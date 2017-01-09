<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
      <meta charset="UTF-8"> 
      <title></title>
      <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
      <script src="js/sweetalert.min.js"></script>
      <script src="js/jquery-1.7.js"></script>
      <script type="text/javascript">
      
      function getMovieMessages(){
                      var action = "searchMovieAction!searchAll.action";
					  var htmlobj = $.ajax({
								url : action,
								type : "POST",
								async : false				
						});				
					var jsonresult = eval("("+htmlobj.responseText+")");
					var result = jsonresult.list;
					var currentcount = result.length;
					document.getElementById("number1").innerHTML=result[0].movieNumber;
					document.getElementById("number2").innerHTML=result[1].movieNumber;
	}
      
      
      
       var mail = null;   
          $(document).ready(function() {
                swal({
					  title: "邮箱",
					  text: "请输入邮箱",
					  type: "input",
					  showCancelButton: false,
					  confirmButtonText: "确认",
					  closeOnConfirm: false,
					  animation: "slide-from-top",
					  inputPlaceholder: "请输入正确的邮箱地址"
					},
					function(inputValue){
					  if (inputValue === false) return false;
					  
					  if (inputValue === "") {
					     swal.showInputError("请输入正确的邮箱地址!");
					     return false
					  }	
					  mail = inputValue;
					  /*关闭swal  */
					  swal.close()   	  
			      });
			      
			      setInterval("getMovieMessages()",3000);                            		      						      
                
          });             
      
            function sellTicket1(){
                  var number = parseInt(document.getElementById("number1").innerHTML);
                  if(number <300){
                      number += 1;
                      document.getElementById("number1").innerHTML=number;
                      swal("您已购票成功！"); 
                  }else{
                      swal("票已售空");
                  }
            }
            function sellTicket2(){
                  var number = parseInt(document.getElementById("number2").innerHTML);
                  if(number <300){
                      number += 1;
                      document.getElementById("number2").innerHTML=number;
                      swal("您已购票成功！"); 
                  }else{
                      swal("票已售空");
                  }
            }  
            
            function minus(){
                  var number = parseInt(document.getElementById("number2").innerHTML);
                  if(number <300){
                      var action = "searchMovieAction!minusNumber.action";
					  var htmlobj = $.ajax({
								url : action,
								type : "POST",
								data : {"mailAddress":mail},
								async : false				
						});				
					  var jsonresult = eval("("+htmlobj.responseText+")");
					  var result = jsonresult.flag;					  
	                  if( !(result.flag) ){
	                     swal("后台报错");
	                  } 
                      number += 1;
                      document.getElementById("number2").innerHTML=number;
                      swal("您已购票成功！"); 
                  }else{
                      swal("票已售空");
                      return ;
                  }                                
            }                                
            
      </script>
</head>
<body>
     <div>
         <table border="1" align="center" >
			  <tr>
			    <th width="300px">电影名</th>
			    <th width="300px">剩余数目</th>
			    <th width="300px">购买</th>
			  </tr>
			  <tr>
			    <th>大圣归来</th>
			    <th id="number1" ></th>
			    <th><a href="#"  onclick="sellTicket1()">购买</a></th>
			  </tr>
			  <tr>
			    <th>功夫熊猫</th>
			    <th id=number2></th>
			    <th><a href="javascript:void(0)" onclick="minus()">购买</a></th>
			  </tr>
		</table>
     </div>
</body>
</html>
