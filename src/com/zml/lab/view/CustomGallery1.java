package com.zml.lab.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;

public class CustomGallery1 extends Gallery {
    private Camera mCamera = new Camera();
    private int mCoveflowCenter;
    private int mMaxRotationAngle = 60;
    private int mMaxZoom = -120;

    public CustomGallery1(Context paramContext) {
        super(paramContext);
        setStaticTransformationsEnabled(true);
    }

    public CustomGallery1(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setStaticTransformationsEnabled(true);
    }

    public CustomGallery1(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setStaticTransformationsEnabled(true);
    }

    private int getCenterOfCoverflow() {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
    }

    private static int getCenterOfView(View paramView) {
        return paramView.getLeft() + paramView.getWidth() / 2;
    }

    private void transformImageBitmap(ImageView paramImageView, Transformation paramTransformation, int paramInt) {
        this.mCamera.save();
        Matrix localMatrix = paramTransformation.getMatrix();
        int i = paramImageView.getLayoutParams().height;
        int j = paramImageView.getLayoutParams().width;
        int k = Math.abs(paramInt);
        this.mCamera.translate(0.0F, 0.0F, 100.0F);
        if (k < this.mMaxRotationAngle) {
            float f = (float)(this.mMaxZoom + 1.5D * k);
            this.mCamera.translate(0.0F, 0.0F, f);
        }
        this.mCamera.rotateY(paramInt);
        this.mCamera.getMatrix(localMatrix);
        localMatrix.preTranslate(-(j / 2), -(i / 2));
        localMatrix.postTranslate(j / 2, i / 2);
        this.mCamera.restore();
    }

    protected boolean getChildStaticTransformation(View child, Transformation t) {
        int childCenter = getCenterOfView(child);
        int childWidth = child.getWidth();
        int rotationAngle = 0;
        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);
        if (childCenter == this.mCoveflowCenter) {
            transformImageBitmap((ImageView)child, t, 0);
        } else {
            rotationAngle = (int)((this.mCoveflowCenter - childCenter) / childWidth * this.mMaxRotationAngle);
            if (Math.abs(rotationAngle) > this.mMaxRotationAngle) {
                rotationAngle = (rotationAngle < 0) ? -mMaxRotationAngle: mMaxRotationAngle;
            }
            transformImageBitmap((ImageView)child, t, rotationAngle);
        }
        return true;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public int getMaxRotationAngle() {
        return this.mMaxRotationAngle;
    }

    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public void setMaxRotationAngle(int paramInt) {
        this.mMaxRotationAngle = paramInt;
    }

    public void setMaxZoom(int paramInt) {
        this.mMaxZoom = paramInt;
    }
}
