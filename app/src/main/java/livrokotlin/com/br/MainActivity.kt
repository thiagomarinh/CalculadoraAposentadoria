package livrokotlin.com.br

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter


class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_calcular = findViewById<TextView>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
        listOf("masculino", "feminino"))

        btn_calcular.setOnClickListener{
            // capturando o sexo selecionado
            val sexo = spn_sexo.selectedItem as String

            // capturando a idade digitada
            val idade = txt_idade.text.toString().toInt() // transformo o tipo editable para string e depois para int

            // variavel para guardar o resultado do calculo
            var resultado = 0

            // verificar o sexo da pessoa
            if (sexo == "masculino"){
                resultado = 65 - idade
            } else{
                resultado = 60 - idade
            }

            // Atualizando a tela de acordo com o resultado do calculo
            txt_resultado.text = "Faltam $resultado anos para você se aposentar"
        }



    }
}