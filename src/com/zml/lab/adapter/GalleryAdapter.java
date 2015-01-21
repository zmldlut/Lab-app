package com.zml.lab.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.zml.lab.base.BaseUi;
import com.zml.lab.util.ScreenSize;

public class GalleryAdapter extends BaseAdapter {

    private Gallery.LayoutParams layoutParams;
    private Context mContext;
    private int[] mImageIds;
    private String[] mTexts;
    private ImageView[] mImages;
    private TextPaint mPaint;
    private float mTextSize;

    public GalleryAdapter(Context paramContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        this.mTexts = new String[paramArrayOfInt2.length];
        for (int i = 0; ; i++) {
            if (i >= paramArrayOfInt2.length) {
                this.mContext = paramContext;
                this.mImageIds = paramArrayOfInt1;
                this.mImages = new ImageView[this.mImageIds.length];
                checkScreenAndTextSize();
                initPaint();
                return;
            }
            this.mTexts[i] = paramContext.getString(paramArrayOfInt2[i]);
        }
    }

    public GalleryAdapter(Context paramContext, int[] paramArrayOfInt, String[] paramArrayOfString) {
        this.mContext = paramContext;
        this.mImageIds = paramArrayOfInt;
        this.mTexts = paramArrayOfString;
        this.mImages = new ImageView[this.mImageIds.length];
        checkScreenAndTextSize();
        initPaint();
    }

    private void checkScreenAndTextSize() {
        ScreenSize.getScreenSize((BaseUi)mContext);
        int i = ScreenSize.screenWidth;
        int j = ScreenSize.screenHeight;
        Log.e("zml", "i="+i);
        Log.e("zml", "j="+j);
        if ((240 == i) && (320 == j))
        {
          this.layoutParams = new Gallery.LayoutParams(100, 80);
          this.mTextSize = 12.0F;
        }
          if ((320 == i) && (480 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(110, 120);
            this.mTextSize = 14.0F;
          }
          else if ((320 == i) && (533 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(120, 120);
            this.mTextSize = 10.0F;
          }
          else if ((480 == i) && ((800 == j) || (854 == j)))
          {
            if (1.5F == ScreenSize.density)
            {
              this.layoutParams = new Gallery.LayoutParams(180, 200);
              this.mTextSize = 22.0F;
            }
            else
            {
              this.layoutParams = new Gallery.LayoutParams(180, 200);
              this.mTextSize = 18.0F;
            }
          }
          else if ((480 == i) && (764 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(180, 200);
            this.mTextSize = 14.0F;
          }
          else if ((600 == i) && (800 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(180, 140);
            this.mTextSize = 22.0F;
          }
          else if ((480 == i) && (960 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(180, 200);
            this.mTextSize = 22.0F;
          }
          else if ((540 == i) && (960 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(180, 200);
            this.mTextSize = 22.0F;
          }
          else if ((640 == i) && (960 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(280, 240);
            this.mTextSize = 22.0F;
          }
          else if ((600 == i) && ((976 == j) || (1024 == j)))
          {
            this.layoutParams = new Gallery.LayoutParams(240, 250);
            this.mTextSize = 16.0F;
          }
          else if ((768 == i) && (1024 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(280, 240);
            this.mTextSize = 22.0F;
          }
          else if ((720 == i) && (1184 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(280, 260);
            this.mTextSize = 28.0F;
          }
          else if ((720 == i) && (1280 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(280, 260);
            this.mTextSize = 28.0F;
          }
          else if ((800 == i) && (1280 == j))
          {
            if (1.0F == ScreenSize.density)
            {
              this.layoutParams = new Gallery.LayoutParams(280, 270);
              this.mTextSize = 18.0F;
            }
            else
            {
              this.layoutParams = new Gallery.LayoutParams(290, 300);
              this.mTextSize = 26.0F;
            }
          }
          else if ((1080 == i) && (1800 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(350, 300);
            this.mTextSize = 42.0F;
          }
          else if ((1080 <= i) && (1920 <= j))
          {
            this.layoutParams = new Gallery.LayoutParams(350, 330);
            this.mTextSize = 50.0F;
          }
          else if ((1280 == i) && (800 == j))
          {
            this.layoutParams = new Gallery.LayoutParams(300, 300);
            this.mTextSize = 16.0F;
          }
          else
          {
            this.layoutParams = new Gallery.LayoutParams(180, 190);
            this.mTextSize = 20.0F;
          }
//        this.layoutParams = new Gallery.LayoutParams(i/3, j/4);
//        this.mTextSize = 16.0F;
    }

    private void initPaint() {
        this.mPaint = new TextPaint(1);
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.density = ScreenSize.density;
        this.mPaint.setTextSize(this.mTextSize);
    }

    public void changeData(int[] paramArrayOfInt, String[] paramArrayOfString) {
        this.mTexts = paramArrayOfString;
        this.mImageIds = paramArrayOfInt;
        notifyDataSetChanged();
    }

//    public boolean createImageViews() {
//        // The gap we want between the reflection and the original image
//        final int reflectionGap = 4;
//        
//
//
//        int index = 0;
//        for (int imageId : mImageIds) {
//            Bitmap originalImage = BitmapFactory.decodeResource(mContext
//                    .getResources(), imageId);
//            int width = originalImage.getWidth();
//            int height = originalImage.getHeight();
//
//            // This will not scale but will flip on the Y axis
//            Matrix matrix = new Matrix();
//            matrix.preScale(1, -1);
//
//            // Create a Bitmap with the flip matrix applied to it.
//            // We only want the bottom half of the image
//            Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
//                    height / 2, width, height / 2, matrix, false);
//
//            // Create a new bitmap with same width but taller to fit
//            // reflection
//            Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
//                    (height + height / 2), Config.ARGB_8888);
//
//            // Create a new Canvas with the bitmap that's big enough for
//            // the image plus gap plus reflection
//            Canvas canvas = new Canvas(bitmapWithReflection);
//            // Draw in the original image
//            canvas.drawBitmap(originalImage, 0, 0, null);
//            // Draw in the gap
//            Paint deafaultPaint = new Paint();
//            canvas.drawRect(0, height, width, height + reflectionGap,
//                    deafaultPaint);
//            // Draw in the reflection
//            canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
//
//            // Create a shader that is a linear gradient that covers the
//            // reflection
//            Paint paint = new Paint();
//            LinearGradient shader = new LinearGradient(0, originalImage
//                    .getHeight(), 0, bitmapWithReflection.getHeight()
//                    + reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);
//            // Set the paint to use this shader (linear gradient)
//            paint.setShader(shader);
//            // Set the Transfer mode to be porter duff and destination in
//            paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
//            // Draw a rectangle using the paint with our linear gradient
//            canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
//                    + reflectionGap, paint);
//            //���ͼƬ�ľ������
//            BitmapDrawable bd = new BitmapDrawable(bitmapWithReflection);
//            bd.setAntiAlias(true);
//
//            ImageView imageView = new ImageView(mContext);
//            //imageView.setImageBitmap(bitmapWithReflection);
//            imageView.setImageDrawable(bd);
//            imageView.setLayoutParams(layoutParams);
//            // imageView.setScaleType(ScaleType.MATRIX);
//            mImages[index++] = imageView;
//
//        }
//        return true;
//    }
    
    public void createImageViews() {
        Log.e("zml", "createImageViews"+ this.mImageIds.length);
        for (int i = 0; ; i++) {
            if (i >= this.mImageIds.length)
                return;
            Bitmap localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), this.mImageIds[i]);
            Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();
            Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(localBitmap2);
            localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
            localCanvas.drawText(this.mTexts[i], localBitmap1.getWidth() / 2 - this.mPaint.measureText(this.mTexts[i]) / 2.0F, localBitmap1.getHeight() - 3.0F * localFontMetrics.bottom, this.mPaint);
            ImageView localImageView = new ImageView(this.mContext);
            localImageView.setImageBitmap(localBitmap2);
            localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            localImageView.setLayoutParams(this.layoutParams);
            this.mImages[i] = localImageView;
            localBitmap1.recycle();
        }
    }

    @Override
    public int getCount() {
        return this.mImageIds.length;
    }

    @Override
    public Object getItem(int paramInt) {
        return Integer.valueOf(paramInt);
    }

    @Override
    public long getItemId(int paramInt) {
        return paramInt;
    }

    @Override
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Log.e("zml", paramInt+"");
        return this.mImages[paramInt];
    }
}
