package com.technowave.unittest.viewModels

import androidx.lifecycle.*
import com.technowave.unittest.models.ItemModel
import com.technowave.unittest.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepo: MainRepo) : ViewModel() {
    private val _last10Items = MutableLiveData<List<ItemModel>>()
    val last10Items: LiveData<List<ItemModel>>
        get() = _last10Items

    fun insertItem(itemModel: ItemModel) = viewModelScope.launch {
        mainRepo.insertItem(itemModel)
    }

    fun getLast10Items() = viewModelScope.launch {
        _last10Items.value = mainRepo.getLast10Items()
    }

}