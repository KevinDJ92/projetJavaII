document.addEventListener("DOMContentLoaded", function(event) {
    console.log("DOM fully loaded and parsed");
  
    document.getElementById('img_produit').addEventListener('change', readURL, true);
    
    function readURL(){
    	   var file = document.getElementById("img_produit").files[0];
    	 
    	   var reader = new FileReader();
    	   
    	   reader.onloadend = function(){
    	      document.getElementById('clock').style.backgroundImage = "url(" + reader.result + ")";        
    	   }
    	   if(file){
    	      reader.readAsDataURL(file);
    	    }else{
     
    	    }
    	}
});
