package br.com.uedat.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        var params = intent.extras
        var nome = params?.getString("name")
        getSupportActionBar()?.setTitle("$nome")

        recycler_disciplinas?.layoutManager = LinearLayoutManager(this)


    }
    private var disciplinas = listOf<Disciplina>()
    override fun onResume(){
        super.onResume()
        Thread{
            disciplinas = DisciplinaService.getDisciplinas()

            runOnUiThread{
                recycler_disciplinas?.adapter = DisciplinaAdapter(disciplinas) {
                    onClickDisciplina(it)
                }
            }
        }.start()
    }

    fun onClickDisciplina(disciplina: Disciplina){
        Toast.makeText(this, "Clicou Disciplina $(disciplina.nome)", Toast.LENGTH_LONG).show()
    }

}