<!DOCTYPE html>
<html>
    <head>
        <title>App_2</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS_folder/scene.css">
        <script type="text/JavaScript" src="${pageContext.request.contextPath}/JS_folder/scene.js"></script>
                                 <!--  The CSS properties : -->
        <style>
        </style>
                                 <!--  The JavaScript properties : -->
        <script>
        </script>
    </head>
<body>
<div>
  <section class="section_nav1">
   <span style="font-size: 26px;"><span style="font-size: 40px;color: #0084ff;text-decoration: overline;">T</span>alkBox</span>

   <ul>
    <li><a href="">Home</a></li>
    <li><a href="">Chat</a></li>
    <li><a href="">Contacts</a></li>
    <li><a href="">Settings</a></li>
    <li><a href="">Terms Of Use</a></li>
   </ul>
  </section>
  <section class="section_nav2">

    <input type="text" name="search" id="search" placeholder="Search">
    <input type="button" value="Clear Chat" id="clear_chat">
    <input type="button" value="More" id="more">
  </section>

<section id="section_messages">
   <div class="div_in_3_section" style="width: 400px;">
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