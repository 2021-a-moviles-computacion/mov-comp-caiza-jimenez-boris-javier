package com.example.examens2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examens2.R
import com.example.examens2.databinding.FragmentHomeBinding
import com.example.examens2.ui.adaptadores.AdaptadorPelicula
import com.example.examens2.ui.clases.Pelicula
import com.example.examens2.ui.clases.Persona
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class HomeFragment : Fragment() {

    val list = mutableListOf<CarouselItem>()

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val carousel: ImageCarousel = root.findViewById(R.id.carousel)
        list.add(CarouselItem("https://i1.wp.com/observadorlatino.com/wp-content/uploads/2021/09/La-web-oficial-de-Matrix-4-te-permite-tomar-la-pi%CC%81ldora-roja-o-la-pi%CC%81ldora-azul-para-tener-un-vistazo-del-film.jpeg?fit=798%2C420&ssl=1"))
        list.add(CarouselItem("https://spoiler.bolavip.com/__export/1599141673526/sites/bolavip/img/2020/09/03/no_time_to_die_james_bond.jpg_209557733.jpg"))
        carousel.addData(list)
        val context = container!!.context

        //////////////Peliculas
        var recyclerPelicula = root.findViewById<RecyclerView>(R.id.home_rv_pelicula)


        recyclerPelicula.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
        // recycler.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerPelicula.adapter = AdaptadorPelicula(generarPeliculas(),context)


        return root
    }

    private fun generarPeliculas():ArrayList<Pelicula>{
        var lista = ArrayList<Pelicula>()

        //pulp fiction
        var categoriasPelicula1 = ArrayList<String>()
        categoriasPelicula1.add("Crime")
        categoriasPelicula1.add("Drama")

        lista.add(
            Pelicula(
                R.drawable.pl_p_pulp_fiction,
                R.drawable.pl_t_pulp_fiction,
                "Pulp Fiction",
                "8.9",
                "1994",
                "1994 R 2h 34min",
                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                "Quentin Tarantino",
                "Quentin Tarantino(stories by) Roger Avary(stories by)",
                categoriasPelicula1,
                generarPersonasPulp()


            )
        )

        //interestellar
        var categoriasPelicula2 = ArrayList<String>()
        categoriasPelicula2.add("Adventure")
        categoriasPelicula2.add("Drama")
        categoriasPelicula2.add("Sci-fi")
        lista.add(
            Pelicula(
                R.drawable.pl_p_interstellar,
                R.drawable.pl_t_interstellar,
                "Interstellar",
                "8.6",
                "2014",
                "2014 PG-13 2h 49min",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "Christopher Nolan",
                "Jonathan Nolan Christopher Nolan",
                categoriasPelicula2,
                generarPersonasInterestellar()

            )
        )


        //the notebook
        var categoriasPelicula3 = ArrayList<String>()
        categoriasPelicula3.add("Drama")
        categoriasPelicula3.add("Romance")

        lista.add(
            Pelicula(
                R.drawable.pl_p_the_notebook,
                R.drawable.pl_t_the_notebook,
                "The Notebook",
                "7.8",
                "2004",
                "2004 PG-13 2h 3min",
                "A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom, but they are soon separated because of their social differences.",
                "Nick Cassavetes",
                "Jeremy Leven(screenplay) Jan Sardi(adaptation) Nicholas Sparks(novel)",
                categoriasPelicula3,
                generarPersonasNotebook()

            )
        )


        //Naranja mecanica
        var categoriasPelicula4 = ArrayList<String>()
        categoriasPelicula4.add("Crime")
        categoriasPelicula4.add("Drama")
        categoriasPelicula4.add("Sci-Fi")

        lista.add(
            Pelicula(
                R.drawable.pl_p_a_clockwork_orange,
                R.drawable.pl_t_a_clockwork_orange,
                "A Clockwork Orange",
                "8.3",
                "1971",
                "1971 R 2h 16min",
                "In the future, a sadistic gang leader is imprisoned and volunteers for a conduct-aversion experiment, but it doesn't go as planned. ",
                "Stanley Kubrick",
                "Stanley Kubrick(screenplay) Anthony Burgess(novel)",
                categoriasPelicula4,
                generarPersonasNaranja()

            )
        )

        //matrix
        var categoriasPelicula5 = ArrayList<String>()
        categoriasPelicula5.add("Action")
        categoriasPelicula5.add("Sci-Fi")

        lista.add(
            Pelicula(
                R.drawable.pl_p_the_matrix,
                R.drawable.pl_t_the_matrix,
                "The Matrix",
                "8.7",
                "1999",
                "1999 R 2h 16min",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                "Lilly Wachowski Lana Wachowski",
                "Lilly Wachowski Lana Wachowski",
                categoriasPelicula5,
                generarPersonasMatrix()

            )
        )

        return  lista
    }

    private fun generarPersonasPulp():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_john_travolta,
                "John Travolta",
                "Vincent Vega"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_uma_thurman,
                "Uma Thurman",
                "Mia Wallace"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_samuel_jackson,
                "Samuel L. Jackson",
                "Jules Winnfield"
            )
        )

        lista.add(
            Persona(
                R.drawable.pr_bruce_willis,
                "Bruce Willis",
                "Butch Coolidge"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_tim_roth,
                "Tim Roth",
                "Pumpkin"
            )
        )

        return lista
    }

    private fun generarPersonasNaranja():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_malcom_mcdowell,
                "Malcolm McDowell",
                "Alex"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_patrick_magee,
                "Patrick Magee",
                "Mr Alexander"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_warren_clarke,
                "Warren Clarke",
                "Dim"
            )
        )

        lista.add(
            Persona(
                R.drawable.pr_clive_francis,
                "Clive Francis",
                "Lodger"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_miriam_karlin,
                "Miriam Karlin",
                "Catlady"
            )
        )

        return lista
    }

    private fun generarPersonasNotebook():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_gena_rowlands,
                "Gena Rowlands",
                "Allie Calhoun"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_ryan_gosling,
                "Ryan Gosling",
                "Noah"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_rachel_mcadams,
                "Rachel McAdams",
                "Allie"
            )
        )

        lista.add(
            Persona(
                R.drawable.pr_kevin_connolly,
                "Kevin Connolly",
                "Fin"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_james_garner,
                "James Garner",
                "Duke"
            )
        )

        return lista
    }

    private fun generarPersonasMatrix():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_keanu_reeves,
                "Keanu Reeves",
                "Neo"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_laurence_fishburne,
                "Laurence Fishburne",
                "Morpheus"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_carrie_ann_moss,
                "Carrie-Anne Moss",
                "Trinity"
            )
        )

        lista.add(
            Persona(
                R.drawable.pr_hugo_weaving,
                "Hugo Weaving",
                "Agent Smith"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_gloria_foster,
                "Gloria Foster",
                "Oracle"
            )
        )

        return lista
    }

    private fun generarPersonas():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_scarlet_johanson,
                "Scarleth Johanson",
                "Natasha Romanoff"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_scarlet_johanson,
                "Scarleth Johanson2",
                "Natasha Romanoff"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_scarlet_johanson,
                "Scarleth Johanson3",
                "Natasha Romanoff"
            )
        )

        return lista
    }

    private fun generarPersonasInterestellar():ArrayList<Persona>{
        var lista = ArrayList<Persona>()

        lista.add(
            Persona(
                R.drawable.pr_matthew_mcconaughey,
                "Matthew McConaughey",
                "Cooper"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_mackenzie_foy,
                "Mackenzie Foy",
                "Murph"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_timothee_chalamet,
                "Timothée Chalamet",
                "Tom"
            )
        )

        lista.add(
            Persona(
                R.drawable.pr_anne_hathaway,
                "Anne Hathaway",
                "Brand"
            )
        )
        lista.add(
            Persona(
                R.drawable.pr_matt_damon,
                "Matt Damon",
                "Mann"
            )
        )

        return lista
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}