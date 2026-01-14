package luca.carlino.loginauthapp.ui.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import luca.carlino.loginauthapp.R
import luca.carlino.loginauthapp.databinding.FragmentOnBoardingBinding

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    private val vm: OnBoardingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.avatarCat.setOnClickListener { vm.selectAvatar("avatar_cat") }
        binding.avatarDog.setOnClickListener { vm.selectAvatar("avatar_dog") }
        binding.avatarFox.setOnClickListener { vm.selectAvatar("avatar_fox") }

        binding.finishButton.setOnClickListener {
            val parsedAge = binding.ageEdit.text?.toString()?.toIntOrNull() ?: 18
            vm.age.value = parsedAge
            vm.onFinish()
        }

        vm.goHome.observe(viewLifecycleOwner) { e ->
            e.getContentIfNotHandled()?.let {
                findNavController().navigate(R.id.action_onboarding_to_home)
            }
        }
    }

    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}