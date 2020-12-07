package com.sem.level5task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sem.level5task2.R
import com.sem.level5task2.model.Game
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabSave.setOnClickListener {
            onAddGame()
        }
    }

    private fun onAddGame() {
        val gameTitle = tilGameTitle.text.toString()
        val gamePlatform = tilGamePlatform.text.toString()
        val gameRelease = GregorianCalendar(tilReleaseYear.text.toString().toInt(), tilReleaseMonth.text.toString().toInt() -1, tilReleaseDay.text.toString().toInt())
        val sdf = SimpleDateFormat("d MMMM yyyy", Locale.US)
        val formatted = sdf.format(gameRelease.time)

        if(gameTitle.isNotBlank() && gamePlatform.isNotBlank()) {
            viewModel.insertGame(Game(gameTitle, gamePlatform, formatted.toString()))

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                getString(R.string.field_blank_error), Toast.LENGTH_SHORT
            ).show()
        }

    }

}