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
	var monP = document.getElementById("monP");
	
	var monBouton = document.getElementById("monBouton");
	
	monBouton.onclick = function() {
	var xhr =getXMLHttpRequest();
		
	xhr.open(
			"GET",
			"getResponse",
			true
	);
	
	
	xhr.send(null);
		
	if(xhr.readyState == 4 && xhr.status == 200){
		retour = xhr.responseText;
		
		monP.innerHTML = retour;
	}
	
	var retour = null;	
	
	xhr.onreadystatechange = function (){
		
	};
	
	
	};
	
	
	

	
	
}; 

