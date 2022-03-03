package com.dms.wordle.adapters

import android.content.Context
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.ItemType
import com.dms.wordle.R
import com.dms.wordle.databinding.MyItemBinding
import com.dms.wordle.models.AddCharInEdittext
import com.dms.wordle.models.ChatItem
import com.dms.wordle.ui.home.HomeRepository
import com.dms.wordle.utility.ManageUI
import com.dms.wordle.utility.Utils


class MyAdapter(
    private val mContext: Context,
    private val homeRepository: HomeRepository,
    private val mList: ArrayList<ChatItem>,
    private val digit: Int
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: MyItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.my_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        setKeyboardAction(digit, holder.binding, position)
        ManageUI.manageTextEdit(
            digit = digit,
            position = position,
            binding = holder.binding,
            homeRepository = homeRepository
        )


//        with(holder.binding) {
//            editText.onFocusChangeListener = FocusEditText(editText, holder.binding)
//            editText1.onFocusChangeListener = FocusEditText(editText1, holder.binding)
//            editText2.onFocusChangeListener = FocusEditText(editText2, holder.binding)
//            editText3.onFocusChangeListener = FocusEditText(editText3, holder.binding)
//            editText4.onFocusChangeListener = FocusEditText(editText4, holder.binding)
//            editText5.onFocusChangeListener = FocusEditText(editText5, holder.binding)
//            editText6.onFocusChangeListener = FocusEditText(editText6, holder.binding)
//            editText7.onFocusChangeListener = FocusEditText(editText7, holder.binding)
//        }

        holder.binding.editText.customSelectionActionModeCallback = actionMode()
        holder.binding.editText1.customSelectionActionModeCallback = actionMode()
        holder.binding.editText2.customSelectionActionModeCallback = actionMode()
        holder.binding.editText3.customSelectionActionModeCallback = actionMode()
        holder.binding.editText4.customSelectionActionModeCallback = actionMode()
        holder.binding.editText5.customSelectionActionModeCallback = actionMode()
        holder.binding.editText6.customSelectionActionModeCallback = actionMode()
        holder.binding.editText7.customSelectionActionModeCallback = actionMode()

        val editTextList = ArrayList<EditText>()
        editTextList.add(holder.binding.editText)
        editTextList.add(holder.binding.editText1)
        editTextList.add(holder.binding.editText2)
        editTextList.add(holder.binding.editText3)
        editTextList.add(holder.binding.editText4)
        editTextList.add(holder.binding.editText5)
        editTextList.add(holder.binding.editText6)
        editTextList.add(holder.binding.editText7)

        homeRepository.addCharInEdittext.add(AddCharInEdittext("", editTextList, holder.binding))

        for (i in homeRepository.addCharInEdittext[position].editText.indices) {
            homeRepository.addCharInEdittext[position].editText[i].setOnClickListener {
                setColor(homeRepository.addCharInEdittext[position].editText[i], position, i, digit)
            }
        }

        if(position == mList.size -1) {
//            homeRepository.manageUI()
        }

//        holder.binding.editText.setOnClickListener {
//            setColor(holder.binding.editText, position, 0, digit)
//        }
//
//        holder.binding.editText1.setOnClickListener {
//            setColor(holder.binding.editText1, position, 1, digit)
//        }
//
//        holder.binding.editText2.setOnClickListener {
//            setColor(holder.binding.editText2, position, 2, digit)
//        }
//
//        holder.binding.editText3.setOnClickListener {
//            setColor(holder.binding.editText3, position, 3, digit)
//        }
//
//        holder.binding.editText4.setOnClickListener {
//            setColor(holder.binding.editText4, position, 4, digit)
//        }
//
//        holder.binding.editText5.setOnClickListener {
//            setColor(holder.binding.editText5, position, 5, digit)
//        }
//
//        holder.binding.editText6.setOnClickListener {
//            setColor(holder.binding.editText6, position, 6, digit)
//        }
//
//        holder.binding.editText7.setOnClickListener {
//            setColor(holder.binding.editText7, position, 7, digit)
//        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private fun setColor(editText: EditText, position: Int, writePosition: Int, digit: Int) {
        if (digit == 5) {
            homeRepository.fiveOfList[writePosition].char = editText.text.toString()
            when (homeRepository.fiveOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.fiveOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.fiveOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.fiveOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(
                mContext,
                homeRepository.fiveOfList[writePosition].type.getColors()
            )
        }

        if (digit == 6) {
            when (homeRepository.sixOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.sixOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.sixOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.sixOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(
                mContext,
                homeRepository.sixOfList[writePosition].type.getColors()
            )
        }

        if (digit == 7) {
            when (homeRepository.sevenOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.sevenOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.sevenOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.sevenOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(
                mContext,
                homeRepository.sevenOfList[writePosition].type.getColors()
            )
        }

        if (digit == 8) {
            when (homeRepository.eightOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.eightOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.eightOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.eightOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(
                mContext,
                homeRepository.eightOfList[writePosition].type.getColors()
            )
        }
    }

    private fun setKeyboardAction(digit: Int, binding: MyItemBinding, position: Int) {

        binding.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText1.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText2.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText3.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText4.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//              checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText5.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Utils.hideKeyBoard(mContext, binding.editText)
//                checkDigit(digit, binding, position)
                true
            } else {
                false
            }
        }

        binding.editText6.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//              checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

        binding.editText7.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//              checkDigit(digit, binding, position)
                Utils.hideKeyBoard(mContext, binding.editText)
                true
            } else {
                false
            }
        }

//        if (digit == 5) {
//            binding.editText4.imeOptions = EditorInfo.IME_ACTION_DONE
//            binding.editText4.setOnEditorActionListener { _, actionId, _ ->
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    if (binding.editText.text.isNotEmpty() &&
//                        binding.editText1.text.isNotEmpty() &&
//                        binding.editText2.text.isNotEmpty() &&
//                        binding.editText3.text.isNotEmpty() &&
//                        binding.editText4.text.isNotEmpty()
//                    ) {
//                        for (i in 0 until homeRepository.fiveOfList.size) {
//                            homeRepository.addInList(i, homeRepository.fiveOfList[i].type, binding)
//                        }
//
//                        homeRepository.fiveOfList.clear()
//                        homeRepository.fiveOfList = Utils.items(5)
//                        Utils.hideKeyBoard(mContext, binding.editText)
//                        homeRepository.checkIsWrite(position)
//                    } else {
//                        Toast.makeText(mContext, "Fill the row ", Toast.LENGTH_SHORT).show()
//                    }
//                    true
//                } else false
//            }
//        }
//
//        if (digit == 6) {
//            binding.editText5.imeOptions = EditorInfo.IME_ACTION_DONE
//            binding.editText5.setOnEditorActionListener { _, actionId, _ ->
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    for (i in 0 until homeRepository.sixOfList.size) {
//                        homeRepository.addInList(i, homeRepository.sixOfList[i].type, binding)
//                    }
//                    homeRepository.sixOfList.clear()
//                    homeRepository.sixOfList = Utils.items(6)
//                    Utils.hideKeyBoard(mContext, binding.editText)
//                    homeRepository.checkIsWrite(position)
//                    true
//                } else false
//            }
//        }
//
//        if (digit == 7) {
//            binding.editText6.imeOptions = EditorInfo.IME_ACTION_DONE
//            binding.editText6.setOnEditorActionListener { _, actionId, _ ->
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    for (i in 0 until homeRepository.sevenOfList.size) {
//                        homeRepository.addInList(i, homeRepository.sevenOfList[i].type, binding)
//                    }
//                    homeRepository.sevenOfList.clear()
//                    homeRepository.sevenOfList = Utils.items(7)
//                    Utils.hideKeyBoard(mContext, binding.editText)
//                    homeRepository.checkIsWrite(position)
//                    Utils.hideKeyBoard(mContext, binding.editText)
//                    true
//                } else false
//            }
//        }
//
//        if (digit == 8) {
//            binding.editText7.imeOptions = EditorInfo.IME_ACTION_DONE
//            binding.editText7.setOnEditorActionListener { _, actionId, _ ->
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    for (i in 0 until homeRepository.fiveOfList.size) {
//                        homeRepository.addInList(i, homeRepository.eightOfList[i].type, binding)
//                    }
//                    homeRepository.eightOfList.clear()
//                    homeRepository.eightOfList = Utils.items(8)
//                    homeRepository.checkIsWrite(position)
//                    Utils.hideKeyBoard(mContext, binding.editText)
//                    true
//                } else false
//            }
//        }
    }

//    private fun checkDigit(digit: Int, binding: MyItemBinding, position: Int) {
//        if (digit == 5) {
//            if (binding.editText.text.isNotEmpty() &&
//                binding.editText1.text.isNotEmpty() &&
//                binding.editText2.text.isNotEmpty() &&
//                binding.editText3.text.isNotEmpty() &&
//                binding.editText4.text.isNotEmpty()
//            ) {
//                for (i in 0 until homeRepository.fiveOfList.size) {
//                    homeRepository.addInList(i, homeRepository.fiveOfList[i].type, binding)
//                }
//
//                homeRepository.fiveOfList.clear()
//                homeRepository.fiveOfList = Utils.items(5)
//                Utils.hideKeyBoard(mContext, binding.editText)
//                homeRepository.checkIsWrite(position)
//            } else {
//                Toast.makeText(mContext, "Fill the row ", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        if (digit == 6) {
//            if (binding.editText.text.isNotEmpty() &&
//                binding.editText1.text.isNotEmpty() &&
//                binding.editText2.text.isNotEmpty() &&
//                binding.editText3.text.isNotEmpty() &&
//                binding.editText4.text.isNotEmpty() &&
//                binding.editText5.text.isNotEmpty()
//            ) {
//                for (i in 0 until homeRepository.sixOfList.size) {
//                    homeRepository.addInList(i, homeRepository.sixOfList[i].type, binding)
//                }
//                homeRepository.sixOfList.clear()
//                homeRepository.sixOfList = Utils.items(6)
//                Utils.hideKeyBoard(mContext, binding.editText)
//                homeRepository.checkIsWrite(position)
//            } else {
//                Toast.makeText(mContext, "Fill the row ", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        if (digit == 7) {
//            if (binding.editText.text.isNotEmpty() &&
//                binding.editText1.text.isNotEmpty() &&
//                binding.editText2.text.isNotEmpty() &&
//                binding.editText3.text.isNotEmpty() &&
//                binding.editText4.text.isNotEmpty() &&
//                binding.editText5.text.isNotEmpty() &&
//                binding.editText6.text.isNotEmpty()
//            ) {
//                for (i in 0 until homeRepository.sixOfList.size) {
//                    homeRepository.addInList(i, homeRepository.sevenOfList[i].type, binding)
//                }
//                homeRepository.sevenOfList.clear()
//                homeRepository.sevenOfList = Utils.items(6)
//                Utils.hideKeyBoard(mContext, binding.editText)
//                homeRepository.checkIsWrite(position)
//            } else {
//                Toast.makeText(mContext, "Fill the row ", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        if (digit == 8) {
//            if (binding.editText.text.isNotEmpty() &&
//                binding.editText1.text.isNotEmpty() &&
//                binding.editText2.text.isNotEmpty() &&
//                binding.editText3.text.isNotEmpty() &&
//                binding.editText4.text.isNotEmpty() &&
//                binding.editText5.text.isNotEmpty() &&
//                binding.editText6.text.isNotEmpty() &&
//                binding.editText7.text.isNotEmpty()
//            ) {
//                for (i in 0 until homeRepository.sixOfList.size) {
//                    homeRepository.addInList(i, homeRepository.eightOfList[i].type, binding)
//                }
//                homeRepository.eightOfList.clear()
//                homeRepository.eightOfList = Utils.items(6)
//                Utils.hideKeyBoard(mContext, binding.editText)
//                homeRepository.checkIsWrite(position)
//            } else {
//                Toast.makeText(mContext, "Fill the row ", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    private fun actionMode(): ActionMode.Callback {
        return object : ActionMode.Callback {
            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(p0: ActionMode?) {
            }
        }
    }

    class FocusEditText(private val selectedEditText: EditText, val binding: MyItemBinding) : View.OnFocusChangeListener {
        override fun onFocusChange(view: View?, isSelect: Boolean) {
//            selectedEditText.setSelection(selectedEditText.text.length)
//            binding.editText1.setSelection(binding.editText1.text.length)
//            binding.editText2.setSelection(binding.editText2.text.length)
//            binding.editText3.setSelection(binding.editText3.text.length)
//            binding.editText4.setSelection(binding.editText4.text.length)
//            binding.editText5.setSelection(binding.editText5.text.length)
//            binding.editText6.setSelection(binding.editText6.text.length)
//            binding.editText7.setSelection(binding.editText7.text.length)
        }
    }
}