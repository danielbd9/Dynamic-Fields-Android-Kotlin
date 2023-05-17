package com.example.androiddynamicfields.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.androiddynamicfields.R
import com.example.androiddynamicfields.databinding.ActivityMainBinding
import com.example.androiddynamicfields.model.FieldModel
import com.example.androiddynamicfields.model.OptionModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupView()
    }

    private fun setupView() {
        addSpinnerOptions()
        addTextView()
        addEditText()
        addCheckBox()
        addRadioButton()
        addImageView()
    }

    private fun createDynamicTextView(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val textView = TextView(this)

            textView.text = fieldName.name

            textView.id = fieldName.id //View.generateViewId()

            textView.layoutParams = layoutParams(MARGIN_TEXT)

            binding.myLayout.addView(textView)
        }
    }

    private fun createDynamicEdiText(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val editText = EditText(this)

            editText.setTextIsSelectable(true)

            editText.hint = fieldName.name

            editText.id = fieldName.id //View.generateViewId()

            editText.layoutParams = layoutParams(MARGIN_TEXT)

            binding.myLayout.addView(editText)
        }
    }

    private fun createDynamicCheckBox(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val checkBox = CheckBox(this)

            checkBox.text = fieldName.name

            checkBox.isChecked = false

            checkBox.id = fieldName.id

            checkBox.layoutParams = layoutParams(MARGIN_CHECK)

            binding.myLayout.addView(checkBox)
        }
    }

    private fun createDynamicRadioButton(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val radioButton = RadioButton(this)
            radioButton.text = fieldName.name

            radioButton.isChecked = false

            radioButton.id = fieldName.id

            radioButton.layoutParams = layoutParams(MARGIN_CHECK)

            binding.myLayout.addView(radioButton)
        }
    }

    private fun createDynamicImageView(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val imageView = ImageView(this)

            imageView
                .setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,R.drawable.android_robot__2014_2019_))

            imageView.id = fieldName.id

            imageView.layoutParams = layoutParams(MARGIN_CHECK)

            binding.myLayout.addView(imageView)
        }
    }

    private fun createDynamicSpinner(fieldNames: List<FieldModel>) {
        for (fieldName in fieldNames) {

            val spinner = Spinner(this)

            val spinnerAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                fieldName.options?.map { p -> p.name } ?: emptyList()
            )

            spinnerAdapter.setDropDownViewResource(R.layout.spinner_item_layout)

            spinner.id = fieldName.id

            spinner.adapter = spinnerAdapter

            spinner.layoutParams = layoutParams(MARGIN_TEXT)

            binding.myLayout.addView(spinner)
        }
    }

    private fun addImageView() {
        val mock1 = FieldModel(1, "Image 1", null)
        val mock2 = FieldModel(2, "Image 2", null)
        val imageList = listOf(mock1, mock2)
        createDynamicImageView(imageList)
    }

    private fun addCheckBox() {
        val mock1 = FieldModel(1, "CheckBox 1", null)
        val mock2 = FieldModel(2, "CheckBox 2", null)
        val checkList = listOf(mock1, mock2)
        createDynamicCheckBox(checkList)
    }

    private fun addRadioButton() {
        val mock1 = FieldModel(1, "Radio 1", null)
        val mock2 = FieldModel(1, "Radio 2", null)
        val checkList = listOf(mock1, mock2)
        createDynamicRadioButton(checkList)
    }

    private fun addEditText() {
        val mock1 = FieldModel(1, "Edit Text 1", null)
        val mock2 = FieldModel(2, "Edit Text 2", null)
        val editTextList = listOf(mock1, mock2)
        createDynamicEdiText(editTextList)
    }

    private fun addTextView() {
        val mock1 = FieldModel(1, "Text 1", null)
        val mock2 = FieldModel(2, "Text 2", null)
        val textList = listOf(mock1, mock2)
        createDynamicTextView(textList)
    }

    private fun addSpinnerOptions() {
        val mockOption = OptionModel(0, "Select Option")
        val mockOption1 = OptionModel(1, "Option 1")
        val mockOption2 = OptionModel(2, "Option 2")

        val select1 = FieldModel(1, "Select 1", listOf(mockOption, mockOption1, mockOption2))
        val select2 = FieldModel(2, "Select 2", listOf(mockOption, mockOption1, mockOption2))

        val spinnerOptions = listOf(select1, select2)
        createDynamicSpinner(spinnerOptions)
    }

    private fun layoutParams(marginTop: Int): LinearLayout.LayoutParams {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(MARGIN_DEFAULT, marginTop, MARGIN_DEFAULT, MARGIN_DEFAULT)
        return layoutParams
    }

    companion object {
        private const val MARGIN_DEFAULT = 0
        private const val MARGIN_CHECK = 30
        private const val MARGIN_TEXT = 100
    }
}