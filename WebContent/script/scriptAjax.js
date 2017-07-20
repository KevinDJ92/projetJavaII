function getXMLHttpRequest(){
	var xhr = null;
	if(window.XMLHttpRequest || window.ActiveXObject ){
		// si internet explorer
		if (window.ActiveXObject) {
		  try {
		     xhr = new ActiveXObject("Msxml2.XMLHTTP");
		  } catch(e) {
		     xhr = new ActiveXObject("Microsoft.XMLHTTP");
		  }
		//sinon c est mozilla ou chrome
		} else {
			xhr = new XMLHttpRequest(); 
		}		
		
	}else{		
		alert("change de PC");
		return null;
	}
	
	return xhr;
}

window.onload = function(){
	var maDiv = document.getElementById("maDiv");
	var monBouton = document.getElementById("monBouton");
	
	monBouton.onclick = function() {
	var xhr = getXMLHttpRequest();
		
	xhr.open(
			"GET",
			"getResponse",
			true
	);
	
	xhr.send(null);
	
	var retour = null;	
	
	xhr.onreadystatechange = function (){
		if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200){
			retour = xhr.responseText;
			
			maDiv.innerHtml = "";	
			var obj = JSON.parse(retour);
			
			for(var etu in obj){
				var etudiant = {
					"nom":obj[etu]["nom"],
					"prenom":obj[etu]["prenom"]
				}
			
//				var div = document.createElement("div");
//				div.className = "maClass";
//				
//				var h3 = document.createElement("h3");
//				h3.innerHTML = etudiant.nom;
//				
//				var p = document.createElement("p");
//				p.innerHTML = etudiant.prenom;
//				
//				div.appendChild(h3);
//				div.appendChild(p);
//			
//				maDiv.appendChild(div);		
				}
			};
		}; 
	};
}