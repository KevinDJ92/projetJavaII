document.addEventListener("DOMContentLoaded", function(event) {
    console.log("DOM fully loaded and parsed");
  
    document.getElementById('ajouterProduit').addEventListener('change', function(){
    	
    	
    });
    document.getElementById('retirerProduit').addEventListener('change', function(){
    	
    	
    }); 
});

function ajouterProduitPanier(nom){
	if (typeof(Storage) !== "undefined") {    
		
		var valeur = localStorage.getItem(nom);
		valeur++;
		localStorage.setItem(nom);
	}
}

function retirerProduitPanier(nom){
	if (typeof(Storage) !== "undefined") {    
		
		var valeur = localStorage.getItem(nom);
		valeur++;
		localStorage.setItem(nom);
	}
}