package com.safe.systemOfWork.ui.activity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.CompoundButton
import android.widget.DatePicker
import com.safe.systemOfWork.R
import com.safe.systemOfWork.model.Conversation
import kotlinx.android.synthetic.main.activity_add_conversation.*
import kotlinx.android.synthetic.main.activity_add_conversation.view.*
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS
import kotlin.math.log

class AddConversationActivity : AppCompatActivity() {

    private val cal: Calendar = Calendar.getInstance()
    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            showDatePicker()
        }
    private var conversaiton = Conversation()
    private val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, minute)
        timeET.setText(SimpleDateFormat("HH:mm").format(cal.time))
        conversaiton.time = timeET.text.toString()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_conversation)
        dateET.showSoftInputOnFocus = false
        clickListener()

        touchListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun touchListener() {
        siteET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
        commentET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
        causeOfUnsafeET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
        taskObservedET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
        observerNameET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
        nameObservedET.setOnTouchListener { view, event ->
            view.parent.requestDisallowInterceptTouchEvent(true)
            if ((event.action and MotionEvent.ACTION_MASK) == MotionEvent.ACTION_SCROLL) {
                view.parent.requestDisallowInterceptTouchEvent(false)
            } else {
            }
            return@setOnTouchListener false
        }
    }

    private fun clickListener() {
        dateET.setOnClickListener {
            DatePickerDialog(this@AddConversationActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        timeET.setOnClickListener {

            TimePickerDialog(this, timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true).show()
        }
        officeCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Office"
                warehouseCB.isChecked = false
                vehicleCB.isChecked = false
                rampCB.isChecked = false
                contractorCB.isChecked = false
                yardCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        warehouseCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Warehouse"
                officeCB.isChecked = false
                vehicleCB.isChecked = false
                rampCB.isChecked = false
                contractorCB.isChecked = false
                yardCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        vehicleCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Vehicle"
                officeCB.isChecked = false
                warehouseCB.isChecked = false
                rampCB.isChecked = false
                contractorCB.isChecked = false
                yardCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        rampCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Ramp"
                officeCB.isChecked = false
                warehouseCB.isChecked = false
                vehicleCB.isChecked = false
                contractorCB.isChecked = false
                yardCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        contractorCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Contractors"
                officeCB.isChecked = false
                warehouseCB.isChecked = false
                vehicleCB.isChecked = false
                rampCB.isChecked = false
                yardCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        yardCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Yard"
                officeCB.isChecked = false
                warehouseCB.isChecked = false
                vehicleCB.isChecked = false
                rampCB.isChecked = false
                contractorCB.isChecked = false
                workshopCB.isChecked = false
            }
        }
        workshopCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.whereObserved = "Workshop"
                officeCB.isChecked = false
                warehouseCB.isChecked = false
                vehicleCB.isChecked = false
                rampCB.isChecked = false
                contractorCB.isChecked = false
                yardCB.isChecked = false
            }
        }
        safeCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.behaviourObserved = "Safe"
                unsafeCB.isChecked = false
            }
        }
        unsafeCB.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                conversaiton.behaviourObserved = "Unsafe"
                safeCB.isChecked = false
            }
        }



        submitBtn.setOnClickListener {
            if (validateFields()) {
                initDataToObject()
                val intent = Intent()
                intent.putExtra("CONVERSATION", conversaiton)
                setResult(RESULT_OK, intent)
                finish()
            } else {
                showAlert(this, "Alert!", "Please fill out the required fields")
            }
        }
    }

    private fun showAlert(context: Context?, title: String?, message: String?) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                "Ok"
            ) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private  fun validateFields() : Boolean {
        if (dateET.text.isEmpty() || timeET.text.isEmpty() || siteET.text.isEmpty() || observerNameET.text.isEmpty() ||
                nameObservedET.text.isEmpty() || taskObservedET.text.isEmpty()) {
            return false
        }
        return true
    }

    private fun initDataToObject() {
        conversaiton.taskObserved = taskObservedET.text.toString()
        conversaiton.behaviourCodes.manualHandle = manualSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.PPE = ppeSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.MHE = mheSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.workplace = workplaceSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.workEquipment = workEquipSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.roadTransport = roadTransSpinner.selectedItem.toString()
        conversaiton.behaviourCodes.procedure = procedureSpinner.selectedItem.toString()
        conversaiton.site = siteET.text.toString()
        conversaiton.observerName = observerNameET.text.toString()
        conversaiton.personObservedName = nameObservedET.text.toString()
        conversaiton.causeOfUnsafe = causeOfUnsafeET.text.toString()
        conversaiton.comment = commentET.text.toString()
        conversaiton.actionCode = actionCodeSpinner.selectedItem.toString()
    }

    private fun showDatePicker() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault()).format(cal.time)
        dateET.setText(sdf)
        conversaiton.date = dateET.text.toString()
    }
}