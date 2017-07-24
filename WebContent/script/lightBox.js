document.addEventListener("DOMContentLoaded", function(event) {
    console.log('DOM Construit');
  
    var lbBg = document.getElementById('lightBoxBg');
    var lb = document.getElementById('lightBox');
    var nomDuProduit = document.getElementById('nomDuProduit');
    var prixDuProduit = document.getElementById('prixDuProduit');
    var img_lb = lb.getElementsByTagName('img');
    
    var buttonOptions = document.getElementsByClassName('btn-panier');
    console.log('Length: ', buttonOptions.length);
    
    for (var i = 0; i < buttonOptions.length; i++) {
    	buttonOptions[i].addEventListener('click', openOptions);
    }
    
   function openOptions(){
	   console.log('openOptions');
	   var parent = this.parentElement;
	   	   
	   var listProduitPrix = parent.getElementsByClassName('produitPrix');
	   
	   var listProduitNom = parent.getElementsByClassName('produitNom');
	   var listProduitNom = parent.getElementsByClassName('produitId');
	   
	   var prixProduit = listProduitPrix[0].innerHTML;
	   var nomProduit = listProduitNom[0].innerHTML;
	   
	   var imgProduit = parent.getElementsByTagName('img');
	   var imgSrc = imgProduit[0].src;
	   var imgAlt = imgProduit[0].alt;
	   
	   nomDuProduit.innerHTML = nomProduit;
	   prixDuProduit.innerHTML = prixProduit;
	   
	   img_lb[0].src = imgSrc;
	   img_lb[0].alt = imgAlt;
	   
	   lbBg.style.display = "block";
	   lb.style.display = "block";
    }

   	 //    function exitOptions(){
   	 //        lbBg.style.display = "none";
   	 //        lb.style.display = "none";
   	 //    }

    //    var buttonEnd = document.getElementById('buttonEnd');
    //    buttonEnd.addEventListener('click', exitOptions);

});