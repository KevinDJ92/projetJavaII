document.addEventListener("DOMContentLoaded", function(event) {
    console.log("DOM fully loaded and parsed");
  
    var nom;
    
    document.getElementById('ajouterProduit').addEventListener('change', function(e){
    	if (typeof(Storage) !== "undefined") {    
    		nom = e.previousSibling.src;
    		
    		var valeur = localStorage.getItem(nom);
    		valeur++;
    		localStorage.setItem(valeur);
    	}
    });
    
    document.getElementById('retirerProduit').addEventListener('change', function(){
    	if (typeof(Storage) !== "undefined") {    
    		nom = e.previousSibling.src;
    		
    		var valeur = localStorage.getItem(nom);
    		valeur++;
    		localStorage.setItem(nom);
    	}
    }); 
});
