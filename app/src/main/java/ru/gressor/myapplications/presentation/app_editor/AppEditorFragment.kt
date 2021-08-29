package ru.gressor.myapplications.presentation.app_editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.gressor.myapplications.R
import ru.gressor.myapplications.databinding.FragmentAppEditorBinding
import ru.gressor.myapplications.domain.entities.App

class AppEditorFragment : Fragment() {
    private var binding: FragmentAppEditorBinding? = null
    private var app: App? = null
    private val vModel: AppEditorVModel by viewModels {
        AppEditorVModelFactory(app)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentAppEditorBinding.inflate(inflater, container, false)
        .also {
            binding = it
            app = arguments?.getParcelable(KEY_APP) as? App
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vModel.stateFlow.collect { renderState(it) }
            }
        }

        views {
            saveAppButton.setOnClickListener {
                vModel.saveNewApp(
                    nameEditText.text.toString(),
                    packageEditText.text.toString(),
                    tagsEditText.text.toString()
                )
            }
        }
    }

    private fun renderState(state: AppEditorState) {
        views {
            when (state) {
                is AppEditorState.New -> {
                    saveAppButton.text = getString(R.string.save_app_button_caption_new)
                }
                is AppEditorState.Old -> {
                    saveAppButton.text = getString(R.string.save_app_button_caption_old)
                    packageEditText.setText(state.appPackage)
                    nameEditText.setText(state.name)
                    tagsEditText.setText(state.tags)
                }
                is AppEditorState.Error -> {
                    Toast.makeText(context, state.throwable.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun <T> views(block: FragmentAppEditorBinding.() -> T): T? = binding?.block()

    companion object {
        fun getInstance(app: App?) =
            AppEditorFragment()
                .apply {
                    app?.let {
                        arguments = bundleOf(KEY_APP to it)
                    }
                }

        private const val KEY_APP = "KEY_APP"
    }
}