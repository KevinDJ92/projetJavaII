const ajouterPanier = "ajouter au panier";
const retirerPanier = "retirer au panier";
const classNomProduit = ".produitNom";
const dateExpires = "expires=Thu, 18 Dec 2017 12:00:00 UTC;";
var parentElement;
var cValue;

$(document).ready(function(){
//	var produit = $('.produitsAffiche');
//	var nbProduit = produit.length;
//	
//	for (var i = 0; i < nbProduit; i++){
//		var nomProduit = produit.get(i).find(classNomProduit).html();		
//	
//		if ("undefined" === typeof(getCookie(nomProduit))){
//			
//		}
//	}
//	console.log(produit);
	$('.btn-panier').click(function(){
		parentElement =	$(this).parent(); 
		
		var cName = parentElement.find(classNomProduit).html();
		console.log("NomProduit " + cName);
		
		var cValue = getCookie(cName);
		
		if ("undefined" === typeof(cValue)){
			console.log("Undefined");	
			cValue = 0;
		}
		
		if ($(this).val() == ajouterPanier){
			cValue++;
			console.log("NewValue" + cValue);				
		}
		else if ($(this).val() == retirerPanier){
			if (cValue > 0){
				cValue--;
				console.log("NewValue" + cValue);
			}
		}
			
		setCookie(cName, cValue, dateExpires);
	});
});

function getCookie(name) {
	  var value = "; " + document.cookie;
	  var parts = value.split("; " + name + "=");
	  if (parts.length == 2) return parts.pop().split(";").shift();
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/ProjectTpJavaII";
}