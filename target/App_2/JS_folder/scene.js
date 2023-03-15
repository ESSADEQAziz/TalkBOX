var socket = new WebSocket("ws://localhost:8080/App_2/ServerEndPoint");
//=====================================================================================================
socket.onopen = function() {
    console.log("WebSocket connection opened");
};
//=====================================================================================================
socket.onmessage = function(event) {

    console.log("Received message: " + event.data);

    var SessionUsername=document.getElementById("SessionUsername").value;

    var TabReceivedMessage =event.data.split(":");
    var Friend=TabReceivedMessage[0];
    var ReceivedMessage=TabReceivedMessage[1];

    console.log("SessionUsername: "+SessionUsername+" / Friend: "+Friend);

    var Message=document.createElement("p");
    Message.id='Message';
    

    if(Friend.localeCompare(SessionUsername) == 0){
      Message.innerHTML=ReceivedMessage;
      Message.style.backgroundColor="#f2f2f2";
      Message.style.marginLeft="50%";
      Message.style.right="0px";
      Message.style.borderRadius="10px 1px 10px 10px";
      
    }else{
        Message.innerHTML=event.data;
        Message.style.backgroundColor="#0084ff";
        Message.style.marginRight="50%";
        Message.style.left="0px";
        Message.style.borderRadius="1px 10px 10px 10px";
    }

    var textA=document.getElementById("PlaceMessages");
    var br=document.createElement("br");
    textA.appendChild(Message);
    textA.appendChild(br);
    
};
//===================================================================================================
socket.onclose = function() {
    console.log("WebSocket connection closed");
};
//===================================================================================================
function transfert(){
    var msgfield=document.getElementById("EcrireMessage");
    var msg=document.getElementById("EcrireMessage").value;
    if(msg != ""){
    socket.send(msg);
    msgfield.value="";
    }else{
        alert("Veuillez Remplir le champ de message d'abord.");
    }
}