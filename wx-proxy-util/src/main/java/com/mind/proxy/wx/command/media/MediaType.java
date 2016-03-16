package com.mind.proxy.wx.command.media;

public enum MediaType {
    image, voice, video, thumb;

    public boolean isThumb() {
        if ("thumb".equals(this.toString())) {
            return true;
        }
        return false;
    }

    public static MediaType toMediaType(String type) {
        return MediaType.valueOf(type);
    }
}