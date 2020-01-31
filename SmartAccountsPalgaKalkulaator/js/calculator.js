var salaryOption = "";
var initialSum = 0;
var pension = false;
var tooandjaTootusKindlustusValik = false;
var tootajaTootusKindlustusValik = false;
var tulumaksuVabaValik = false;
var tulumaksuVabaSumma = 500;
var sotsiaalmaksuMiinimum = false;

var tootajaTootuskindlustusProtsent = 1.6;
var tootajaTootuskindlustus = 0;
var kogumisPensionProtsent = 2;
var kogumisPension = 0;
var tulumaksProtsent = 20;
var tulumaks = 0;
var sotsiaalmaksProtsent = 33;
var sotsiaalmaks = 0;
var tooandjaTootuskindlustusProtsent = 0.8;
var tooandjaTootuskindlustus = 0;

var tulumaksMiinimumAlumine = 500;
var tulumaksMiinimumUlemine = 1200;
var tulumaksMaksimum = 2100;

document.getElementById("arvutaButton").onclick = function() {calculate()};

function newStartData(){
	tootajaTootuskindlustus = 0;
	kogumisPension = 0;
	tulumaks = 0;
	sotsiaalmaks = 0;
	tooandjaTootuskindlustus = 0;
	initialSum = 0;
	tulumaksuVabaSumma = 500;
	sotsiaalmaksProtsent = 33;
	tooandjaTootuskindlustusProtsent = 0.8;
}

function calculate(){
	newStartData();
	var e1 = document.getElementById("palgaValik");
	salaryOption = e1.options[e1.selectedIndex].text;
	initialSum = document.getElementById("lahtesumma").value;
	tooandjaTootusKindlustusValik = document.getElementById("tax1").checked;
	tootajaTootusKindlustusValik = document.getElementById("tax2").checked;
	tulumaksuVabaValik = document.getElementById("taxFree").checked;
	sotsiaalmaksuMiinimum = document.getElementById("socialTax").checked;
	pension = document.getElementById("pension").checked;
	if(salaryOption == "kogukulu"){
		kogukuluCalculate();
	} else if(salaryOption == "netopalk"){
		netoCalculate();
	} else if(salaryOption == "brutopalk"){
		brutoCalculate();
	}
}

function brutoCalculate(){
	initialSum = Number(initialSum);
	console.log("bruto");
	
	var netSum, totalSum, taxTotal, yearInitialSum;
	if(tootajaTootusKindlustusValik){
		tootajaTootuskindlustus = initialSum * tootajaTootuskindlustusProtsent / 100;
	}
	if(pension){
		kogumisPension = initialSum * kogumisPensionProtsent / 100;
	}
	if(tulumaksuVabaValik){
		if(initialSum - tootajaTootuskindlustus - kogumisPension <= tulumaksMiinimumAlumine){
			tulumaks = 0;
		} else if (initialSum - tootajaTootuskindlustus - kogumisPension > tulumaksMiinimumAlumine && initialSum <= tulumaksMiinimumUlemine){
			tulumaks = (initialSum - tootajaTootuskindlustus - kogumisPension - tulumaksuVabaSumma) * tulumaksProtsent / 100;
		} else if (initialSum >= 2100){
			tulumaksuVabaSumma = 0;
			tulumaks = (initialSum - tootajaTootuskindlustus - kogumisPension) * tulumaksProtsent / 100;
		} else {
			yearInitialSum = initialSum * 12;
			tulumaksuVabaSumma = (6000 - 6000 / 10800 * (yearInitialSum - 14400))/12;
			tulumaks = (initialSum - tootajaTootuskindlustus - kogumisPension - tulumaksuVabaSumma) * tulumaksProtsent / 100;
		}
	}
	netSum = initialSum - tootajaTootuskindlustus - kogumisPension - tulumaks;
	if(sotsiaalmaksuMiinimum){
		if(initialSum < 540){
			sotsiaalmaks = 178.2;
		} else {
			sotsiaalmaks = initialSum * sotsiaalmaksProtsent / 100;
		}	
	}
	if(tooandjaTootusKindlustusValik){
		tooandjaTootuskindlustus = initialSum * tooandjaTootuskindlustusProtsent / 100;
	}
	totalSum = initialSum + sotsiaalmaks + tooandjaTootuskindlustus;
	taxTotal = tootajaTootuskindlustus + kogumisPension + tulumaks + sotsiaalmaks + tooandjaTootuskindlustus;
	
	document.getElementById("tulumaksuVabaSumma").innerHTML = containsComma(tulumaksuVabaSumma).concat("€");
	
	document.getElementById("postBruto").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postBrutopalk").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postTootusKindlustus1").innerHTML = containsComma(tootajaTootuskindlustus).concat("€");
	document.getElementById("postKogumispension").innerHTML = containsComma(kogumisPension).concat("€");
	document.getElementById("postTulumaks").innerHTML = containsComma(tulumaks).concat("€");
	document.getElementById("postNet1").innerHTML = containsComma(netSum).concat("€");
	document.getElementById("postNet2").innerHTML = containsComma(netSum).concat("€");
	document.getElementById("postSotsiaalmaks").innerHTML = containsComma(sotsiaalmaks).concat("€");
	document.getElementById("postTootusKindlustus2").innerHTML = containsComma(tooandjaTootuskindlustus).concat("€");
	document.getElementById("postKogukulu1").innerHTML = containsComma(totalSum).concat("€");
	document.getElementById("postKogukulu2").innerHTML = containsComma(totalSum).concat("€");
	document.getElementById("postMaksuametile").innerHTML = containsComma(taxTotal).concat("€");
	
	var tulumaksuProtsent2 = tulumaks * 100 / initialSum;
	var tulumaksuProtsent2Str = roundToOne(tulumaksuProtsent2).toString();
	
	var netosummaProtsent = netSum * 100 / initialSum;
	var netosummaProtsentStr = roundToOne(netosummaProtsent).toString();
	
	var tootajaTootuskindlustusProtsent2 = tootajaTootuskindlustus * 100 / initialSum;
	var tootajaTootuskindlustusProtsent2Str = roundToOne(tootajaTootuskindlustusProtsent2).toString();
	
	var kogumisPensionProtsent2 = kogumisPension * 100 / initialSum;
	var kogumisPensionProtsent2Str = roundToOne(kogumisPensionProtsent2).toString();
	
	var sotsiaalmaksProtsent2 = sotsiaalmaks * 100 / totalSum;
	var sotsiaalmaksProtsent2Str = roundToOne(sotsiaalmaksProtsent2).toString();
	
	var brutopalkProtsent = initialSum * 100 / totalSum;
	var brutopalkProtsentStr = roundToOne(brutopalkProtsent).toString();
	
	var tooandjaTootuskindlustusProtsent2 = tooandjaTootuskindlustus * 100 / totalSum;
	var tooandjaTootuskindlustusProtsent2Str = roundToOne(tooandjaTootuskindlustusProtsent2).toString();
	
	var netosummaProtsent2 = netSum * 100 / totalSum;
	var netosummaProtsent2Str = roundToOne(netosummaProtsent2).toString();

	var maksuametileProtsent = taxTotal * 100 / totalSum;
	var maksuametileProtsentStr = roundToOne(maksuametileProtsent).toString();
	
	document.getElementById("appendTulumaks").innerHTML = tulumaksuProtsent2Str.concat("%");
	document.getElementById("appendNet1").innerHTML = netosummaProtsentStr.concat("%");
	document.getElementById("appendNet2").innerHTML = netosummaProtsent2Str.concat("%");
	document.getElementById("appendMaksuametile").innerHTML = maksuametileProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus1").innerHTML = tootajaTootuskindlustusProtsent2Str.concat("%");
	document.getElementById("appendKogumispension").innerHTML = kogumisPensionProtsent2Str.concat("%");
	document.getElementById("appendSotsiaalmaks").innerHTML = sotsiaalmaksProtsent2Str.concat("%");
	document.getElementById("appendBrutopalk").innerHTML = brutopalkProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus2").innerHTML = tooandjaTootuskindlustusProtsent2Str.concat("%");
	
}

function netoCalculate(){
	console.log("neto");
	initialSum = Number(initialSum);
	var brutoSum, totalSum, taxTotal;
	if(tulumaksuVabaValik){
		tulumaks = (initialSum - tulumaksuVabaSumma) * 20 / 80;
	}
	var taxSum1 = 100 - tootajaTootuskindlustusProtsent - kogumisPensionProtsent;
	if(tootajaTootusKindlustusValik){
		tootajaTootuskindlustus = (initialSum + tulumaks) * tootajaTootuskindlustusProtsent / taxSum1;
	}
	if(pension){
		kogumisPension = (initialSum + tulumaks) * kogumisPensionProtsent / taxSum1;
	}
	brutoSum = initialSum + tulumaks + tootajaTootuskindlustus + kogumisPension;
	
	if(sotsiaalmaksuMiinimum){
		sotsiaalmaks = brutoSum * sotsiaalmaksProtsent / 100;
	}
	if(tooandjaTootusKindlustusValik){
		tooandjaTootuskindlustus = brutoSum * tooandjaTootuskindlustusProtsent / 100;
	}
	totalSum = brutoSum + sotsiaalmaks + tooandjaTootuskindlustus;
	taxTotal = tootajaTootuskindlustus + kogumisPension + tulumaks + sotsiaalmaks + tooandjaTootuskindlustus;
	
	document.getElementById("tulumaksuVabaSumma").innerHTML = containsComma(tulumaksuVabaSumma).concat("€");
	
	document.getElementById("postNet1").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postNet2").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postTulumaks").innerHTML = containsComma(tulumaks).concat("€");
	document.getElementById("postTootusKindlustus1").innerHTML = containsComma(tootajaTootuskindlustus).concat("€");
	document.getElementById("postKogumispension").innerHTML = containsComma(kogumisPension).concat("€");
	document.getElementById("postBruto").innerHTML = containsComma(brutoSum).concat("€");
	document.getElementById("postBrutopalk").innerHTML = containsComma(brutoSum).concat("€");
	document.getElementById("postSotsiaalmaks").innerHTML = containsComma(sotsiaalmaks).concat("€");
	document.getElementById("postTootusKindlustus2").innerHTML = containsComma(tooandjaTootuskindlustus).concat("€");
	document.getElementById("postKogukulu1").innerHTML = containsComma(totalSum).concat("€");
	document.getElementById("postKogukulu2").innerHTML = containsComma(totalSum).concat("€");
	document.getElementById("postMaksuametile").innerHTML = containsComma(taxTotal).concat("€");
	
	var tulumaksuProtsent2 = tulumaks * 100 / brutoSum;
	var tulumaksuProtsent2Str = roundToOne(tulumaksuProtsent2).toString();
	
	var netosummaProtsent = initialSum * 100 / brutoSum;
	var netosummaProtsentStr = roundToOne(netosummaProtsent).toString();
	
	var tootajaTootuskindlustusProtsent2 = tootajaTootuskindlustus * 100 / brutoSum;
	var tootajaTootuskindlustusProtsent2Str = roundToOne(tootajaTootuskindlustusProtsent2).toString();
	
	var kogumisPensionProtsent2 = kogumisPension * 100 / brutoSum;
	var kogumisPensionProtsent2Str = roundToOne(kogumisPensionProtsent2).toString();
	
	var sotsiaalmaksProtsent2 = sotsiaalmaks * 100 / totalSum;
	var sotsiaalmaksProtsent2Str = roundToOne(sotsiaalmaksProtsent2).toString();
	
	var brutopalkProtsent = brutoSum * 100 / totalSum;
	var brutopalkProtsentStr = roundToOne(brutopalkProtsent).toString();
	
	var tooandjaTootuskindlustusProtsent2 = tooandjaTootuskindlustus * 100 / totalSum;
	var tooandjaTootuskindlustusProtsent2Str = roundToOne(tooandjaTootuskindlustusProtsent2).toString();
	
	var netosummaProtsent2 = initialSum * 100 / totalSum;
	var netosummaProtsent2Str = roundToOne(netosummaProtsent2).toString();

	var maksuametileProtsent = taxTotal * 100 / totalSum;
	var maksuametileProtsentStr = roundToOne(maksuametileProtsent).toString();
	
	document.getElementById("appendTulumaks").innerHTML = tulumaksuProtsent2Str.concat("%");
	document.getElementById("appendNet1").innerHTML = netosummaProtsentStr.concat("%");
	document.getElementById("appendNet2").innerHTML = netosummaProtsent2Str.concat("%");
	document.getElementById("appendMaksuametile").innerHTML = maksuametileProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus1").innerHTML = tootajaTootuskindlustusProtsent2Str.concat("%");
	document.getElementById("appendKogumispension").innerHTML = kogumisPensionProtsent2Str.concat("%");
	document.getElementById("appendSotsiaalmaks").innerHTML = sotsiaalmaksProtsent2Str.concat("%");
	document.getElementById("appendBrutopalk").innerHTML = brutopalkProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus2").innerHTML = tooandjaTootuskindlustusProtsent2Str.concat("%");
	
	
}

function kogukuluCalculate(){
	console.log("kogu");
	initialSum = Number(initialSum);
	var brutoSum, netSum, taxTotal, yearBrutoSum;
	if(!sotsiaalmaksuMiinimum){
		sotsiaalmaksProtsent = 0;
	}
	if(!tooandjaTootusKindlustusValik){
		tooandjaTootuskindlustusProtsent = 0;
	}
	var taxSum = 100 + tooandjaTootuskindlustusProtsent + sotsiaalmaksProtsent;
	console.log(taxSum);
	brutoSum = initialSum * 100 / taxSum;
	
	if(sotsiaalmaksuMiinimum){
		sotsiaalmaks = brutoSum * sotsiaalmaksProtsent / 100;
	}
	if(tooandjaTootusKindlustusValik){
		tooandjaTootuskindlustus = brutoSum * tooandjaTootuskindlustusProtsent / 100;
	}
	
	if(tootajaTootusKindlustusValik){
		tootajaTootuskindlustus = brutoSum * tootajaTootuskindlustusProtsent / 100;
	}
	if(pension){
		kogumisPension = brutoSum * kogumisPensionProtsent / 100;
	}
	if(tulumaksuVabaValik){
		if(brutoSum - tootajaTootuskindlustus - kogumisPension <= tulumaksMiinimumAlumine){
			tulumaks = 0;
		} else if (brutoSum - tootajaTootuskindlustus - kogumisPension > tulumaksMiinimumAlumine && brutoSum <= tulumaksMiinimumUlemine){
			tulumaks = (brutoSum - tootajaTootuskindlustus - kogumisPension - tulumaksuVabaSumma) * tulumaksProtsent / 100;
		} else if (initialSum >= 2100){
			tulumaksuVabaSumma = 0;
			tulumaks = (brutoSum - tootajaTootuskindlustus - kogumisPension) * tulumaksProtsent / 100;
		} else {
			yearBrutoSum = brutoSum * 12;
			tulumaksuVabaSumma = (6000 - 6000 / 10800 * (yearBrutoSum - 14400))/12;
			tulumaks = (brutoSum - tootajaTootuskindlustus - kogumisPension - tulumaksuVabaSumma) * tulumaksProtsent / 100;
		}
	}
	netSum = brutoSum - tootajaTootuskindlustus - kogumisPension - tulumaks;
	taxTotal = tootajaTootuskindlustus + kogumisPension + tulumaks + sotsiaalmaks + tooandjaTootuskindlustus;
	
	document.getElementById("tulumaksuVabaSumma").innerHTML = containsComma(tulumaksuVabaSumma).concat("€");
	
	document.getElementById("postKogukulu1").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postKogukulu2").innerHTML = containsComma(initialSum).concat("€");
	document.getElementById("postBruto").innerHTML = containsComma(brutoSum).concat("€");
	document.getElementById("postBrutopalk").innerHTML = containsComma(brutoSum).concat("€");
	document.getElementById("postSotsiaalmaks").innerHTML = containsComma(sotsiaalmaks).concat("€");
	document.getElementById("postTootusKindlustus2").innerHTML = containsComma(tooandjaTootuskindlustus).concat("€");
	document.getElementById("postTootusKindlustus1").innerHTML = containsComma(tootajaTootuskindlustus).concat("€");
	document.getElementById("postKogumispension").innerHTML = containsComma(kogumisPension).concat("€");
	document.getElementById("postTulumaks").innerHTML = containsComma(tulumaks).concat("€");
	document.getElementById("postNet1").innerHTML = containsComma(netSum).concat("€");
	document.getElementById("postNet2").innerHTML = containsComma(netSum).concat("€");
	document.getElementById("postMaksuametile").innerHTML = containsComma(taxTotal).concat("€");
	
	
	var tulumaksuProtsent2 = tulumaks * 100 / brutoSum;
	var tulumaksuProtsent2Str = roundToOne(tulumaksuProtsent2).toString();
	
	var netosummaProtsent = netSum * 100 / brutoSum;
	var netosummaProtsentStr = roundToOne(netosummaProtsent).toString();
	
	var tootajaTootuskindlustusProtsent2 = tootajaTootuskindlustus * 100 / brutoSum;
	var tootajaTootuskindlustusProtsent2Str = roundToOne(tootajaTootuskindlustusProtsent2).toString();
	
	var kogumisPensionProtsent2 = kogumisPension * 100 / brutoSum;
	var kogumisPensionProtsent2Str = roundToOne(kogumisPensionProtsent2).toString();
	
	var sotsiaalmaksProtsent2 = sotsiaalmaks * 100 / initialSum;
	var sotsiaalmaksProtsent2Str = roundToOne(sotsiaalmaksProtsent2).toString();
	
	var brutopalkProtsent = brutoSum * 100 / initialSum;
	var brutopalkProtsentStr = roundToOne(brutopalkProtsent).toString();
	
	var tooandjaTootuskindlustusProtsent2 = tooandjaTootuskindlustus * 100 / initialSum;
	var tooandjaTootuskindlustusProtsent2Str = roundToOne(tooandjaTootuskindlustusProtsent2).toString();
	
	var netosummaProtsent2 = netSum * 100 / initialSum;
	var netosummaProtsent2Str = roundToOne(netosummaProtsent2).toString();

	var maksuametileProtsent = taxTotal * 100 / initialSum;
	var maksuametileProtsentStr = roundToOne(maksuametileProtsent).toString();
	
	document.getElementById("appendTulumaks").innerHTML = tulumaksuProtsent2Str.concat("%");
	document.getElementById("appendNet1").innerHTML = netosummaProtsentStr.concat("%");
	document.getElementById("appendNet2").innerHTML = netosummaProtsent2Str.concat("%");
	document.getElementById("appendMaksuametile").innerHTML = maksuametileProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus1").innerHTML = tootajaTootuskindlustusProtsent2Str.concat("%");
	document.getElementById("appendKogumispension").innerHTML = kogumisPensionProtsent2Str.concat("%");
	document.getElementById("appendSotsiaalmaks").innerHTML = sotsiaalmaksProtsent2Str.concat("%");
	document.getElementById("appendBrutopalk").innerHTML = brutopalkProtsentStr.concat("%");
	document.getElementById("appendTootusKindlustus2").innerHTML = tooandjaTootuskindlustusProtsent2Str.concat("%");
	
	
}

function containsComma(num){
	var answer = 0;
	num = num.toString();
	if(num.includes('.')){
		var index = num.indexOf(".");
		var length = num.length;
		num = Number(num);
		//console.log(num);
		if(length - index-1 == 1){
			num = num.toString();
			answer = num.concat("0");
		} else if(length - index+1 > 2){
			answer = roundToTwo(num);
			answer = answer.toString();
		}
		answer = answer.replace(".", ",");
		return answer;
	} else {
		answer = num.concat(",00");
		return answer;
	}
}

function roundToTwo(num) {
    return +(Math.round(num + "e+2")  + "e-2");
}
function roundToOne(num) {
    return +(Math.round(num + "e+1")  + "e-1");
}

/*


500 kuni 1200 on tulumaksuvaba 500
üle 1200 hakkab tulumaksuvaba vähenema

näide: 600 - 9.60 - 12 = 578.40
578.40 - 500 = 78.40
(78.40 * 20) / 100 = 15.68

näide 2: 1300 - 20.80 - 26 = 1253.20
1253.20 - 444.44 = 808.76
(808.76 * 20) / 100 = 162

netost bruto

600 - 500 = 100
(100*20) / 80 saab tulumaksu summa

100 - 2 - 1.6 = 96.4

600 + 25 = 625 * 2 / 96.4 = 12.97
625 * 1.6 / 96.4 = 10.37

*/