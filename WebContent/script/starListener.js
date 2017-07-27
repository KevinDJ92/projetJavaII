document.addEventListener("DOMContentLoaded", function(event) {
    console.log('DOM Construit');

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
    	var starNumber = starClassName.substring(5, 6)
    	
    	var siblingDuParentDuParent = this.parentElement.parentElement.previousElementSibling;
    	console.log("siblingDuParent: " + siblingDuParentDuParent);
    	
    	var listProduitId = siblingDuParentDuParent.getElementsByClassName('produitId');
    	var produitId = listProduitId[0].value;
    	console.log("ProduitId: " + produitId + " StarNumber: " + starNumber); 
    }
});