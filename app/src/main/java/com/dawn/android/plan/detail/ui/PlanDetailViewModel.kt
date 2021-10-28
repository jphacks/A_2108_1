package com.dawn.android.plan.detail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.plan.domain.model.PlanId
import com.dawn.android.plan.domain.repository.PlanRepository
import com.dawn.android.plan.ui.converter.PlanUIConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlanDetailViewModel(
    private val planId: PlanId,
    private val planRepository: PlanRepository,
) : ViewModel() {

    private val _planDetail = MutableStateFlow<PlanDetailUIModel?>(null)
    val planDetail: StateFlow<PlanDetailUIModel?> get() = _planDetail

    init {
        viewModelScope.launch {
            val uiModel = planRepository.get(planId)
                .let {
                    PlanUIConverter.convertToUIModel(it)
                }
            _planDetail.value = uiModel
        }
    }
}