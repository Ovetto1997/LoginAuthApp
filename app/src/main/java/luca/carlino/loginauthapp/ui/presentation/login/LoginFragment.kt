package luca.carlino.loginauthapp.ui.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import luca.carlino.loginauthapp.R
import luca.carlino.loginauthapp.databinding.FragmentLoginBinding

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val vm : LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginButton.setOnClickListener { vm.onLoginClicked() }

        vm.snackBar.observe(viewLifecycleOwner) {
            e -> e.getContentIfNotHandled()?.let { Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show() }
        }
        vm.goNext.observe(viewLifecycleOwner){ e ->
            e.getContentIfNotHandled().let { findNavController().navigate(R.id.action_login_to_onboarding) }
        }

    }

    override fun onDestroyView() {
        _binding = null; super.onDestroyView()
    }

}