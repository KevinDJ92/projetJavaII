document.addEventListener("DOMContentLoaded", function(event) {
    console.log("DOM fully loaded and parsed");
  
    // TO DO
    document.getElementById('ajouterProduit').addEventListener('change', function(){
    	if (typeof(Storage) !== "undefined") {    
    		
    		var valeur = localStorage.getItem(nom);
    		valeur++;
    		localStorage.setItem(nom);
    	}
    });
    document.getElementById('retirerProduit').addEventListener('change', function(){
    	if (typeof(Storage) !== "undefined") {    
    		
    		var valeur = localStorage.getItem(nom);
    		valeur++;
    		localStorage.setItem(nom);
    	}
    }); 
});
