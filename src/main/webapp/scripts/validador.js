/**
 * Validação de formularios, dos campos
 * Autor: Renato Santana
 */

function validar() {
    let nome = frmContato.nome.value //variável que recebe do form frmContato campo nome o valor
    let fone = frmContato.fone.value
    
    if(nome === "") {
		alert("Preencha o campo Nome")
		frmContato.nome.focus() //posiciona o cursor em cima do campo nome
		return false
	} else if (fone === "") {
		alert("Preencha o campo Fone")
		frmContato.fone.focus() //posiciona o cursor em cima do campo Fone
		return false
	} else {
		document.forms["frmContato"].submit() //envia o formulário dos dados para a camada controller
	}
}