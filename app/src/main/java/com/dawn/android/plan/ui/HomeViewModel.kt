package com.dawn.android.plan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.plan.domain.repository.PlanRepository
import com.dawn.android.plan.timeline.ui.TimelineItemUIModel
import com.dawn.android.plan.ui.converter.PlanUIConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val planRepository: PlanRepository,
) : ViewModel() {

    private val _timelineItems = MutableStateFlow(listOf<TimelineItemUIModel>())
    val timelineItems: StateFlow<List<TimelineItemUIModel>> get() = _timelineItems

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    fun refresh() {
        viewModelScope.launch {
            _loading.value = true
            _timelineItems.value = planRepository
                .getAll()
                .map {
                    PlanUIConverter.convertToUIModel(it)
                }
            _loading.value = false
        }
    }
}
