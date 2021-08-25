package ru.gressor.myapplications.presentation.apps_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.gressor.myapplications.databinding.FragmentAppsListBinding
import ru.gressor.myapplications.presentation.apps_list.adapter.AppsListAdapter

class AppsListFragment : Fragment() {
    private var binding: FragmentAppsListBinding? = null
    private val vModel: AppsListVModel by viewModels()

    private val adapter get() = views { appsListView.adapter as? AppsListAdapter }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentAppsListBinding.inflate(inflater)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        views { appsListView.adapter = AppsListAdapter() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vModel.stateFlow.collect {
                    adapter?.submitList(it)
                }
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun <T> views(block: FragmentAppsListBinding.() -> T): T? = binding?.block()
}