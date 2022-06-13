package com.bijesh.myrxapplication.rxoperators

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bijesh.myrxapplication.databinding.FragmentSimpleBinding
import com.bijesh.myrxapplication.observables.java.SimpleObservable
import com.bijesh.myrxapplication.utils.AppConstant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SimpleFragment : Fragment() {


    private var _binding : FragmentSimpleBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSimpleBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            SimpleObservable.getSimpleObservables()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    binding.textView.append(" onNext : value : $it")
                    binding.textView.append(AppConstant.LINE_SEPARATOR)
                },{
                    binding.textView.append(" onError : " + it.message)
                    binding.textView.append(AppConstant.LINE_SEPARATOR)
                },{
                    binding.textView.append(" onComplete")
                    binding.textView.append(AppConstant.LINE_SEPARATOR)
                })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}