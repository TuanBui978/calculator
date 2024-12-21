package com.example.calculator

import androidx.lifecycle.ViewModel
import com.example.calculator.ui.theme.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainActivityViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    var uiState = _uiState.asStateFlow()

    fun onOperatorClick(operator: String) {
        if (_uiState.value.isOperationClick) {
            _uiState.update {
                it.copy(operation = operator)
            }
        }
        else {
            when (operator) {
                "+" -> {
                    if (_uiState.value.aValue != null) {
                        onEquClick()
                    }
                    _uiState.update {
                        if (it.aValue == null) {
                            it.copy(aValue = it.valueInScreen.toDouble(), operation = operator, isOperationClick = true, currentCalculator = it.valueInScreen)
                        }
                        else {
                            it.copy(operation = operator, isOperationClick = true)
                        }
                    }
                }
                "-" -> {
                    if (_uiState.value.aValue != null) {
                        onEquClick()
                    }
                    _uiState.update {
                        if (it.aValue == null) {
                            it.copy(aValue = it.valueInScreen.toDouble(), operation = operator, isOperationClick = true, currentCalculator = it.valueInScreen)
                        }
                        else {

                            it.copy(operation = operator, isOperationClick = true)
                        }
                    }
                }
                "*" -> {
                    if (_uiState.value.aValue != null) {
                        onEquClick()
                    }
                    _uiState.update {
                        if (it.aValue == null) {
                            it.copy(aValue = it.valueInScreen.toDouble(), operation = operator, isOperationClick = true, currentCalculator = it.valueInScreen)
                        }
                        else {
                            it.copy(operation = operator, isOperationClick = true)
                        }
                    }
                }
                "/" -> {
                    if (_uiState.value.aValue != null) {
                        onEquClick()
                    }
                    _uiState.update {
                        if (it.aValue == null) {
                            it.copy(aValue = it.valueInScreen.toDouble(), operation = operator, isOperationClick = true, currentCalculator = it.valueInScreen)
                        }
                        else {

                            it.copy(operation = operator, isOperationClick = true)
                        }
                    }
                }
            }
        }
    }

    fun onNumButtonClick(num: String) {
        if (_uiState.value.isOperationClick) {
            _uiState.update {
                it.copy(valueInScreen = num, isOperationClick = false)
            }
        }
        else {
            _uiState.update {
                if (it.valueInScreen == "0") {
                    it.copy(valueInScreen = num, isOperationClick = false)
                }
                else {
                    it.copy(valueInScreen = it.valueInScreen + num, isOperationClick = false)
                }
            }
        }

    }

    fun onEquClick() {
        when (_uiState.value.operation) {
            "+" -> {
                _uiState.update {
                    if (it.aValue == null) {
                        it.copy(aValue = it.valueInScreen.toDouble(), isOperationClick = true, currentCalculator = it.valueInScreen)
                    }
                    else {
                        it.copy(valueInScreen =  (it.valueInScreen.toDouble() + it.aValue!!).toString().removeSuffix(".0") , aValue = it.valueInScreen.toDouble() + it.aValue!!, isOperationClick = true, currentCalculator = it.currentCalculator + it.operation + it.valueInScreen)
                    }
                }
            }
            "-" -> {
                _uiState.update {
                    if (it.aValue == null) {
                        it.copy(aValue = it.valueInScreen.toDouble(), isOperationClick = true, currentCalculator = it.valueInScreen)
                    }
                    else {
                        it.copy(valueInScreen =  (- it.valueInScreen.toDouble() + it.aValue!!).toString().removeSuffix(".0") , aValue = + it.valueInScreen.toDouble() - it.aValue!!, isOperationClick = true, currentCalculator = it.currentCalculator + it.operation + it.valueInScreen)
                    }
                }
            }
            "*" -> {
                _uiState.update {
                    if (it.aValue == null) {
                        it.copy(aValue = it.valueInScreen.toDouble(), isOperationClick = true, currentCalculator = it.valueInScreen)
                    }
                    else {
                        it.copy(valueInScreen =  (it.valueInScreen.toDouble() * it.aValue!!).toString().removeSuffix(".0") , aValue = it.valueInScreen.toDouble() * it.aValue!!, isOperationClick = true, currentCalculator = it.currentCalculator + it.operation + it.valueInScreen)
                    }
                }
            }
            "/" -> {
                _uiState.update {
                    if (it.aValue == null) {
                        it.copy(aValue = it.valueInScreen.toDouble(), isOperationClick = true, currentCalculator = it.valueInScreen)
                    }
                    else {
                        it.copy(valueInScreen =  (it.aValue!! / it.valueInScreen.toDouble() ).toString().removeSuffix(".0") , aValue = it.aValue!! / it.valueInScreen.toDouble() , isOperationClick = true, currentCalculator = it.currentCalculator + it.operation + it.valueInScreen)
                    }
                }
            }
        }
    }

    fun onCButtonClick() {
        _uiState.update {
            it.copy("0", null, "", false, "")
        }
    }

    fun onSighButtonClick() {
        _uiState.update {
            it.copy(valueInScreen = (it.valueInScreen.toDouble() * -1).toString().removeSuffix(".0"))
        }
    }

    fun onBackButtonClick() {
        _uiState.update {
            if (it.valueInScreen.length > 1) {
                it.copy(valueInScreen = it.valueInScreen.substring(0, it.valueInScreen.length - 1))
            }
            else {
                it.copy(valueInScreen =  "0")
            }
        }
    }

    fun onPointClick() {
        _uiState.update {
                it.copy(valueInScreen = it.valueInScreen + ".")
        }
    }





}