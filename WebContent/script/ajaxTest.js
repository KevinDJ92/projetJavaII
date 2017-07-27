//var pageCounter = 1;
//var animalContainer = document.getElementById("animal-info");
//var btn = document.getElementById("btn");
//
//btn.addEventListener("click", function() {
//  var ourRequest = new XMLHttpRequest();
//  
//  ourRequest.open('GET', 'https://learnwebcode.github.io/json-example/animals-' + pageCounter + '.json');
//  
//  ourRequest.onload = function() {
//   
//	  if (ourRequest.status >= 200 && ourRequest.status < 400) {
//    
//	  var ourData = JSON.parse(ourRequest.responseText);
//      renderHTML(ourData);
//    } else {
//      console.log("We connected to the server, but it returned an error.");
//    }
//    
//  };
//
//  ourRequest.onerror = function() {
//    console.log("Connection error");
//  };
//
//  ourRequest.send();
//  pageCounter++;
//  if (pageCounter > 3) {
//    btn.classList.add("hide-me");
//  }
//});
//
//function renderHTML(data) {
//  var htmlString = "";
//
//  for (i = 0; i < data.length; i++) {
//    htmlString += "<p>" + data[i].name + " is a " + data[i].species + " that likes to eat ";
//    
//    for (ii = 0; ii < data[i].foods.likes.length; ii++) {
//      if (ii == 0) {
//        htmlString += data[i].foods.likes[ii];
//      } else {
//        htmlString += " and " + data[i].foods.likes[ii];
//      }
//    }
//
//    htmlString += ' and dislikes ';
//
//    for (ii = 0; ii < data[i].foods.dislikes.length; ii++) {
//      if (ii == 0) {
//        htmlString += data[i].foods.dislikes[ii];
//      } else {
//        htmlString += " and " + data[i].foods.dislikes[ii];
//      }
//    }
//
//    htmlString += '.</p>';
//
//  }
//
//  animalContainer.insertAdjacentHTML('beforeend', htmlString);
//}

$(document).ready(function(){

	$('#nomProd').keyup(function(){
		
		var nom = $("#nomProd").val();
		if(nom != ""){$.ajax({
		    url : 'afficheProduitAjax', 
		    type : 'POST',
		    data : {nomProd:nom },
		    dataType : 'json',
		    success : function(data, statut){
			    var product = data;
			    var optionData="";
			    $("#nomRecherche").children().remove();
			    for(var prod in product){
			    	
			    	optionData+='<option value="'+product[prod].nom+'">';
			    }

			    $("#nomRecherche").append(optionData);
		    
		    },
		    error : function(resultat, statut, erreur){
		    	
		    }
		 
		});}
		
		else{
			$("#nomRecherche").children().remove();
		}
		
		
		
		
	});
	
	//suprimer produit du panier
	
$('.deleteProd').click(function(){
		var clicked = $(this);
		var id = $(this).parent().find('#idProdPanier').val();
//		console.log(id);
			$.ajax({
		    url : 'GererPanier', 
		    type : 'POST',
		    data : {idProdDelet:id },
		    success : function(data, statut){
		    	var msgDelete="<p>le produit a ete suprimer de votre panier<p>"
		    		clicked.parent().empty().append(msgDelete).fadeTo(300, 0);
		    	
			    
		    
		    },
		    error : function(resultat, statut, erreur){
		    	
		    }
		 
		});
		
		
		
		
		
		
	});
	
	
});