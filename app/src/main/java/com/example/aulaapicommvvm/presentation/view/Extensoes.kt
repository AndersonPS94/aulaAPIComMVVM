package com.example.aulaapicommvvm.presentation.view

class Usuario(
    val nome: String
) {

    fun logar(){
        println("Usuario logado: ${this.nome}")
    }
    /*fun deslogar(){
        println("Usuario deslogado: ${this.nome}")
    }*/

    fun Usuario.deslogar(){
        println("Usuario deslogado: ${this.nome}")
    }
}
fun main() {
    val usuario = Usuario("Anderson")
    usuario.logar()
   //  usuario.deslogar()

}