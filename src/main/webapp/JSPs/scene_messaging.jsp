<!DOCTYPE html>
<html>
    <head>
        <title>App_2</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS_folder/scene_messaging.css">
        <script type="text/JavaScript" src=""></script>
                                 <!--  The CSS properties : -->
        <style>
        <%@ include file="../CSS_folder/scene_messaging.css" %>
        </style>
                                   <!-- The JavaScript properties : --> 
        <script>
         <%@ include file="../JS_folder/scene_messaging.js" %>
        </script> 
    </head>
<body>
<div>
  <div id="container_logo_nav1">
  <img id="logo" src="<%=request.getContextPath()%>/Images/logo_TalkBOX.png" alt="logo_TalkBOX"></img>
  
  <section class="section_nav1" >
   <ul>
    <li><a href="">Home</a></li>
    <li><a href="">Chat</a></li>
    <li><a href="">Contacts</a></li>
    <li><a href="/App_2/Servlet_4" target="_blank">Settings</a></li>
    <li><a href="">Terms Of Use</a></li>
   </ul>

  </section>
  </div>
  <section class="section_nav2">

    <input type="text" name="search" id="search" placeholder="Search">
    <input type="button" value="Clear Chat" id="clear_chat">
    <input type="button" value="More" id="more">
  </section>

<section id="section_messages">
   <div class="div_in_3_section" style="width: 400px;" id="user_contacts">
  </div>

<div class="div_in_3_section">
  <div  id="PlaceMessages" ></div><br>
   <input type="text" placeholder="Envoyer un message" id="EcrireMessage">
   <button onclick="transfert()" id="envoyer">Envoyer</button>
  </div>



</section>
</div>



<div style="display: none;">
    <input type="hidden" id="SessionUsername" value="${session_username}">
</div>
</body>
</html>