package ro.andreidobrescu.declarativeadapterkt.restaurant.details.cells

import android.content.Context
import kotlinx.android.synthetic.main.cell_your_comment.view.*
import ro.andreidobrescu.declarativeadapterktsample.R
import ro.andreidobrescu.declarativeadapterkt.model.Comment
import ro.andreidobrescu.declarativeadapterkt.view.CellView

class YourCommentCellView : CellView<Comment>
{
    private lateinit var onDeleteListener : (Comment) -> (Unit)

    constructor(context : Context?, onDeleteListener : (Comment) -> (Unit)) : super(context)
    {
        this.onDeleteListener=onDeleteListener
    }

    override fun layout() : Int = R.layout.cell_your_comment

    override fun setData(comment : Comment)
    {
        authorTv.text=comment.author
        createdAtTv.text=comment.createdAt
        messageTv.text=comment.message

        deleteButton.setOnClickListener {
            onDeleteListener(comment)
        }
    }
}
