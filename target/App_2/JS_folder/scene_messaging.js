var socket = new WebSocket("ws://localhost:8080/App_2/ServerEndPoint");
//=====================================================================================================
socket.onopen = function() {
    console.log("WebSocket connection opened");
};
//=====================================================================================================
  // this array is for the resievers of the messages : look line 60 to inderstand .
  const selected_contacts=[];

socket.onmessage = function(event) {

    console.log("Received message: " + event.data);

    var SessionUsername=document.getElementById("SessionUsername").value;

    var TabReceivedMessage =event.data.split(":");
    var indice=Number(TabReceivedMessage[0]);

    if(indice == 1){
        var user_contact=document.getElementById("user_contacts");

        var contact_container=document.createElement("div");
        var pour_design=document.createElement("div"); //Element de design pour la prop flexbox
        var contact_image=document.createElement("img");
        var contact_name=document.createElement("span");
        var contact_status=document.createElement("span");
        var contact_heure=document.createElement("span");

        contact_container.id="contact_container";
        contact_image.id="contact_image";
        contact_name.id="contact_name";
        contact_status.id="contact_status";
        contact_heure.id="contact_heure";
        pour_design.id="pour_design";

        contact_name.innerHTML=TabReceivedMessage[1];

        if(TabReceivedMessage[2].localeCompare(null) == 0){
           contact_status.innerHTML="This is a user of TalkBOX !";
        }else{
           contact_status.innerHTML=TabReceivedMessage[2];
        }
        contact_heure.innerHTML=TabReceivedMessage[3]+":"+TabReceivedMessage[4]+":"+TabReceivedMessage[5];

        contact_image.src="./../Images/brouda.jpg";

        pour_design.append(contact_name,contact_status);
        contact_container.append(contact_image,pour_design,contact_heure);

        user_contact.appendChild(contact_container);

        // For selecting the target contacts :

        contact_container.onclick=function() {select_contact()};
        function select_contact(){
            if(contact_container.style.border == "1.2px solid aqua"){
                contact_container.style.border="1px solid #616161";

                var index = selected_contacts.indexOf(contact_name.innerHTML);
                 if (index !== -1) {
                      selected_contacts.splice(index, 1);
                          }
            }else{
                contact_container.style.border="1.2px solid aqua";
                    selected_contacts.push(contact_name.innerHTML);
            }    
        }

    }else{
        if(indice == 2){
             var Friend=TabReceivedMessage[1];
    console.log("SessionUsername: "+SessionUsername+" / Friend: "+Friend);
    
   
    var ReceivedMessage=TabReceivedMessage[2];
    var Message=document.createElement("p");
    Message.id='Message';
    

    if(Friend.localeCompare(SessionUsername) == 0){
      Message.innerHTML=ReceivedMessage;
      Message.style.backgroundColor="#f2f2f2";
      Message.style.marginLeft="50%";
      Message.style.right="0px";
      Message.style.borderRadius="10px 1px 10px 10px";
      
    }else{
        Message.innerHTML=TabReceivedMessage[1]+":"+TabReceivedMessage[2];
        Message.style.backgroundColor="#0084ff";
        Message.style.marginRight="50%";
        Message.style.color="white";
        Message.style.left="0px";
        Message.style.borderRadius="1px 10px 10px 10px";
    }

    var textA=document.getElementById("PlaceMessages");
    var br=document.createElement("br");
    var br2=document.createElement("br");
    textA.appendChild(Message);
    textA.appendChild(br);
    textA.appendChild(br2);

        }else{
            console.log("Error lors de la reception du constant envoyer par le serverendpoint ! ");
        }
    }
  
};

//===================================================================================================
socket.onclose = function() {
    console.log("WebSocket connection closed");
};
//===================================================================================================
function transfert(){
    var msgfield=document.getElementById("EcrireMessage");
    var msg=document.getElementById("EcrireMessage").value;
    var SessionUsername=document.getElementById("SessionUsername").value;
    if(msg != ""){
    socket.send(msg+":"+selected_contacts.toString()+":"+SessionUsername);
    msgfield.value="";
    }else{
        alert("Veuillez Remplir le champ de message d'abord.");
    }
}