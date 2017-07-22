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
	$('.chercher').click(function(){
//		var categorie = $(".categorie").val;
//		$.ajax({
//			type: 'GET',
//			url: 'AfficherProduit?idProd=1',
//			headers:{
//				Accept : "application/json; charset=utf-8",
//				"Content-Type" : "application/json; charset=utf-8"
//			},
//			success: function(result){
//				var product = $.parseJSON(result);
////				$('.resultat').html(product.nom);
////				alert(result.nom);
//				alert("test");
//				
//			}
//			
			
//		});
//		$.post('AfficherProduit',{nomProd:'asdf'},function(data){
//			//console.log(data);
//			var product = data;
//			
//			alert(product.nom);
//			
//			
//			
//		});
		var nom = $("#nomProd").val();
		console.log(nom);
		$.ajax({
		    url : 'AfficherProduit', // La ressource ciblée
		    type : 'POST', // Le type de la requête HTTP.
		    data : {nomProd:nom},
		    dataType : 'json',
		    success : function(data, statut){
		    var product = data;
		    console.log(product[0].nom);
		    $(".produitsAffiche").remove();
		    var code ="<div class='col-sm-4 col-lg-4 col-md-4 produitsAffiche'>" +
		    		"<div class='thumbnail'>" +
		    		"<img src='img/produits/default.jpg' alt='' class='imgProd'>" +
		    		"<div class='caption'>" +
		    		"<h4 class='pull-right'>"+product[0].prix+" $</h4>" +
		    		"<h4><a href='#'>"+product[0].nom+"</a></h4>" +
		    		"<p>"+product[0].detail+" .</p>" +
		    		"</div>" +
		    		" <div class='ratings'>" +
		    		"<p class='pull-right'></p>" +
		    		"<p>" +
		    		"<span class='glyphicon glyphicon-star modifiable'></span>" +
		    		"<span class='glyphicon glyphicon-star-empty modifiable'></span>" +
		    		"</p>" +
		    		"</div>" +
		    		"</div>" +
		    		"</div>";
//		    var gliphcon = "<span class='glyphicon glyphicon-star modifiable'></span>";
//		    for(i=0 ; i<= product[0].){}
		    
		    
		    
		    
		    
		    
		    
		    
		    $(".rowProds").append(code);
		    },
		    error : function(resultat, statut, erreur){
		      alert("Can't add now");
		    }
		 
		});
		
		
		
	});
	
	
});