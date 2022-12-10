/* This file was generated by SableCC (http://www.sablecc.org/). */

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class APictureClause extends PPictureClause
{
    private TPicture _picture_;
    private TIs _is_;
    private PCharacterString _characterString_;

    public APictureClause()
    {
        // Constructor
    }

    public APictureClause(
        @SuppressWarnings("hiding") TPicture _picture_,
        @SuppressWarnings("hiding") TIs _is_,
        @SuppressWarnings("hiding") PCharacterString _characterString_)
    {
        // Constructor
        setPicture(_picture_);

        setIs(_is_);

        setCharacterString(_characterString_);

    }

    @Override
    public Object clone()
    {
        return new APictureClause(
            cloneNode(this._picture_),
            cloneNode(this._is_),
            cloneNode(this._characterString_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPictureClause(this);
    }

    public TPicture getPicture()
    {
        return this._picture_;
    }

    public void setPicture(TPicture node)
    {
        if(this._picture_ != null)
        {
            this._picture_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._picture_ = node;
    }

    public TIs getIs()
    {
        return this._is_;
    }

    public void setIs(TIs node)
    {
        if(this._is_ != null)
        {
            this._is_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._is_ = node;
    }

    public PCharacterString getCharacterString()
    {
        return this._characterString_;
    }

    public void setCharacterString(PCharacterString node)
    {
        if(this._characterString_ != null)
        {
            this._characterString_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._characterString_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._picture_)
            + toString(this._is_)
            + toString(this._characterString_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._picture_ == child)
        {
            this._picture_ = null;
            return;
        }

        if(this._is_ == child)
        {
            this._is_ = null;
            return;
        }

        if(this._characterString_ == child)
        {
            this._characterString_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._picture_ == oldChild)
        {
            setPicture((TPicture) newChild);
            return;
        }

        if(this._is_ == oldChild)
        {
            setIs((TIs) newChild);
            return;
        }

        if(this._characterString_ == oldChild)
        {
            setCharacterString((PCharacterString) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}