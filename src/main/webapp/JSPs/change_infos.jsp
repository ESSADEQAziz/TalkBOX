<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Settings</title>
<style>
        <%@ include file="../CSS_folder/change_infos.css" %>
</style>

<script>
         <%@ include file="../JS_folder/change_infos.js" %>
</script> 
</head>
<body>
<c:if test="${error_update_username}">
<script> alert(" Password or username confirmation incorrect ! ");</script>
</c:if>
<c:if test="${succes_update_username}">
<script> alert(" Username modified successfully ! ");</script>
</c:if>
<c:if test="${error_update_password}">
<script> alert(" Old Password or password confirmation incorrect ! ");</script>
</c:if>
<c:if test="${succes_update_password}">
<script> alert(" Password modified successfully ! ");</script>
</c:if>
<c:if test="${error_update_status}">
<script> alert(" Password incorrect ! ");</script>
</c:if>
<c:if test="${succes_update_status}">
<script> alert(" Status modified successfully ! ");</script>
</c:if>
<c:if test="${error_update_image}">
<script> alert(" Password incorrect ! ");</script>
</c:if>
<c:if test="${succes_update_image}">
<script> alert(" image modified successfully ! ");</script>
</c:if>

    <div id="container_image_title">
        <img id="logo" src="<%=request.getContextPath()%>/Images/logo_TalkBOX.png" alt="logo_TalkBOX"></img>
        <h2 id="titre">Configuration </h2>
        </div>
 <div id="container_sections">
    <section id="section_1">
       <a href="#div_username"> <img class="img_oper"    src="<%=request.getContextPath()%>/Images/Username_Icon.png" alt="img1"></a>
       <a href="#div_password"><img class="img_oper"    src="<%=request.getContextPath()%>/Images/Password_Icon.png" alt="img2"></a> 
       <a href="#div_image"> <img class="img_oper"    src="<%=request.getContextPath()%>/Images/Image_Icon.png" alt="img3"></a>
        <a href="#div_status"> <img class="img_oper"    src="<%=request.getContextPath()%>/Images/Statue_Icon.png" alt="img4"></a>
        
        </section>
    <section id="section_2">
        <div id="div_username">
            <form id="form_username" method="post" action="Servlet_4">
                <input type="text" value="1" name="filter_number" style="display:none;">
                <input type="text" name="new_username" id="new_username" placeholder="New Username" required>
              
                <input type="text" name="new_username_confirmation" id="new_username_confirmation" placeholder="Confirme Username" required>
              
                <input type="password" name="password1" id="password1" placeholder="password" required>
                <button type="submit" onclick="filter(1)" name="Validate" id="btn_validate">Validate</button>
                
                
                </form>
            </div><br><br><br>
        <div id="div_password">
            <form id="form_password" method="post" action="Servlet_4">
                <input type="text" value="2" name="filter_number" style="display:none;">
                <input type="password" name="new_password" id="new_password" placeholder="New Password" required>
              
                <input type="password" name="new_password_confirmation" id="new_password_confirmation" placeholder="Confirme Password" required>
              
                <input type="password" name="password2" id="password2" placeholder="Old Password" required>
                <button type="submit" name="Validate" id="btn_validate">Validate</button>
                
                
                </form>
            </div><br><br><br>
        <div id="div_image">
            <form id="form_image" method="post" action="Servlet_4" enctype="multipart/form-data">
            <input type="text" value="3" name="filter_number" style="display:none;">
            <label for="image_file">Fichier a envoyer : </label>
            <input type="file" name="image_file" id="image_file" required/>
            <input type="password" name="password3" id="password3" placeholder="password" required>
        <button type="submit" name="Validate" id="btn_validate">Validate</button>
    </form>
            </div><br><br><br>
        <div id="div_status">
            <form id="form_statue" method="post" action="Servlet_4">
                <input type="text" name="filter_number" value="4" style="display:none;">
                <input type="text" name="new_statue" id="new_statue" placeholder="New Statue" required>      
                <input type="password" name="password4" id="password4" placeholder="password" required>
                <button type="submit" name="Validate" id="btn_validate">Validate</button>
                
                </form>
            </div><br><br><br><br><br><br><br><br><br><br>
        </section>   
</div>
</body>
</html>