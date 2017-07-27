document.addEventListener("DOMContentLoaded", function(event) {
    console.log('DOM Construit');

    var produitId;
    var starNumber;
    
    var produitRatingsList = document.getElementsByClassName('ratings');
  
    for (var i = 0; i < produitRatingsList.length; i++) {   	
    	for (var j = 1; j <= 5; j++){
    	   var star = produitRatingsList[i].getElementsByClassName('star_' + j);
    	   star[0].addEventListener('click', selectStar);	
    	}
    }
    
    function selectStar(){ 
    	console.log("starSelected: " + this.className);
    	var starClassName = this.className; 
    	
    	var siblingDuParentDuParent = this.parentElement.parentElement.previousElementSibling;
    	console.log("siblingDuParent: " + siblingDuParentDuParent);
    	
    	var listProduitId = siblingDuParentDuParent.getElementsByClassName('produitId');
    	
    	produitId = listProduitId[0].value;
    	starNumber = starClassName.substring(5, 6);
    	
    	$(document).ready(function(){
    		$.ajax({
    		    url : 'afficherRatingAjax', 
    		    type : 'POST',
    		    data : {id_prod: produitId,
    		    		star_number: starNumber},
    		    dataType : 'json',
    		    success : function(data, statut){
    			    
    		    },
    		    error : function(resultat, statut, erreur){
    		    	
    		    }
    		});
    	});
    }
});

