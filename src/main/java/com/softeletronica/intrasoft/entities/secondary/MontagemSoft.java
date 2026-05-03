package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_montagem_soft")
public class MontagemSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(columnDefinition = "TEXT", name = "area_atuacao")
    private String areaAtuacao;
    @Column(name = "url_img")
    private String urlImg;
    @Column(name = "url_img_2")
    private String urlImg_2;
    @Column(name = "url_img_3")
    private String urlImg_3;
    @Column(name = "url_img_4")
    private String urlImg_4;
    @Column(name = "url_img_5")
    private String urlImg_5;
    @Column(name = "url_img_6")
    private String urlImg_6;
    @Column(name = "url_img_7")
    private String urlImg_7;
    @Column(name = "url_img_8")
    private String urlImg_8;
    @Column(name = "url_img_9")
    private String urlImg_9;
    @Column(name = "url_img_10")
    private String urlImg_10;
    @Column(name = "url_img_11")
    private String urlImg_11;
    @Column(name = "url_img_12")
    private String urlImg_12;
    @Column(name = "url_img_13")
    private String urlImg_13;
    @Column(name = "url_img_14")
    private String urlImg_14;
    @Column(name = "url_img_15")
    private String urlImg_15;
    @Column(name = "url_img_16")
    private String urlImg_16;
    @Column(name = "url_img_17")
    private String urlImg_17;
    @Column(name = "url_img_18")
    private String urlImg_18;
    @Column(name = "url_img_19")
    private String urlImg_19;
    @Column(name = "url_img_20")
    private String urlImg_20;
    @Column(name = "url_img_21")
    private String urlImg_21;
    @Column(name = "url_img_22")
    private String urlImg_22;
    @Column(name = "url_img_23")
    private String urlImg_23;
    @Column(name = "url_img_24")
    private String urlImg_24;
    @Column(name = "url_img_25")
    private String urlImg_25;
    @Column(name = "url_img_26")
    private String urlImg_26;
    @Column(name = "url_img_27")
    private String urlImg_27;
    @Column(name = "url_img_28")
    private String urlImg_28;
    @Column(name = "url_img_29")
    private String urlImg_29;
    @Column(name = "url_img_30")
    private String urlImg_30;





public MontagemSoft(){

}

    public MontagemSoft(Long id, String descricao, String areaAtuacao, String urlImg, String urlImg_2, String urlImg_3,
                        String urlImg_4, String urlImg_5, String urlImg_6, String urlImg_7, String urlImg_8,
                        String urlImg_9, String urlImg_10, String urlImg_11, String urlImg_12, String urlImg_13,
                        String urlImg_14, String urlImg_15, String urlImg_16,String urlImg_17, String urlImg_18, String urlImg_19,
                        String urlImg_20, String urlImg_21, String urlImg_22, String urlImg_23, String urlImg_24,
                        String urlImg_25,String urlImg_26,String urlImg_27,String urlImg_28,String urlImg_29,
                        String urlImg_30) {
        this.id = id;
        this.descricao = descricao;
        this.areaAtuacao = areaAtuacao;
        this.urlImg = urlImg;
        this.urlImg_2 = urlImg_2;
        this.urlImg_3 = urlImg_3;
        this.urlImg_4 = urlImg_4;
        this.urlImg_5 = urlImg_5;
        this.urlImg_6 = urlImg_6;
        this.urlImg_7 = urlImg_7;
        this.urlImg_8 = urlImg_8;
        this.urlImg_9 = urlImg_9;
        this.urlImg_10 = urlImg_10;
        this.urlImg_11 = urlImg_11;
        this.urlImg_12 = urlImg_12;
        this.urlImg_13 = urlImg_13;
        this.urlImg_14 = urlImg_14;
        this.urlImg_15 = urlImg_15;
        this.urlImg_16 = urlImg_16;
        this.urlImg_17 = urlImg_17;
        this.urlImg_18 = urlImg_18;
        this.urlImg_19 = urlImg_19;
        this.urlImg_20 = urlImg_20;
        this.urlImg_21 = urlImg_21;
        this.urlImg_22 = urlImg_22;
        this.urlImg_23 = urlImg_23;
        this.urlImg_24 = urlImg_24;
        this.urlImg_25 = urlImg_25;
        this.urlImg_26 = urlImg_26;
        this.urlImg_27 = urlImg_27;
        this.urlImg_28 = urlImg_29;
        this.urlImg_29 = urlImg_29;
        this.urlImg_30 = urlImg_30;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getUrlImg_2() {
        return urlImg_2;
    }

    public void setUrlImg_2(String urlImg_2) {
        this.urlImg_2 = urlImg_2;
    }

    public String getUrlImg_3() {
        return urlImg_3;
    }

    public void setUrlImg_3(String urlImg_3) {
        this.urlImg_3 = urlImg_3;
    }

    public String getUrlImg_4() {
        return urlImg_4;
    }

    public void setUrlImg_4(String urlImg_4) {
        this.urlImg_4 = urlImg_4;
    }

    public String getUrlImg_5() {
        return urlImg_5;
    }

    public void setUrlImg_5(String urlImg_5) {
        this.urlImg_5 = urlImg_5;
    }

    public String getUrlImg_6() {
        return urlImg_6;
    }

    public void setUrlImg_6(String urlImg_6) {
        this.urlImg_6 = urlImg_6;
    }

    public String getUrlImg_7() {
        return urlImg_7;
    }

    public void setUrlImg_7(String urlImg_7) {
        this.urlImg_7 = urlImg_7;
    }

    public String getUrlImg_8() {
        return urlImg_8;
    }

    public void setUrlImg_8(String urlImg_8) {
        this.urlImg_8 = urlImg_8;
    }

    public String getUrlImg_9() {
        return urlImg_9;
    }

    public void setUrlImg_9(String urlImg_9) {
        this.urlImg_9 = urlImg_9;
    }

    public String getUrlImg_10() {
        return urlImg_10;
    }

    public void setUrlImg_10(String urlImg_10) {
        this.urlImg_10 = urlImg_10;
    }

    public String getUrlImg_11() {
        return urlImg_11;
    }

    public void setUrlImg_11(String urlImg_11) {
        this.urlImg_11 = urlImg_11;
    }

    public String getUrlImg_12() {
        return urlImg_12;
    }

    public void setUrlImg_12(String urlImg_12) {
        this.urlImg_12 = urlImg_12;
    }

    public String getUrlImg_13() {
        return urlImg_13;
    }

    public void setUrlImg_13(String urlImg_13) {
        this.urlImg_13 = urlImg_13;
    }

    public String getUrlImg_14() {
        return urlImg_14;
    }

    public void setUrlImg_14(String urlImg_14) {
        this.urlImg_14 = urlImg_14;
    }

    public String getUrlImg_15() {
        return urlImg_15;
    }

    public void setUrlImg_15(String urlImg_15) {
        this.urlImg_15 = urlImg_15;
    }

    public String getUrlImg_16() {
        return urlImg_16;
    }

    public void setUrlImg_16(String urlImg_16) {
        this.urlImg_16 = urlImg_16;
    }

    public String getUrlImg_17() {
        return urlImg_17;
    }

    public void setUrlImg_17(String urlImg_17) {
        this.urlImg_17 = urlImg_17;
    }

    public String getUrlImg_18() {
        return urlImg_18;
    }

    public void setUrlImg_18(String urlImg_18) {
        this.urlImg_18 = urlImg_18;
    }

    public String getUrlImg_19() {
        return urlImg_19;
    }

    public void setUrlImg_19(String urlImg_19) {
        this.urlImg_19 = urlImg_19;
    }

    public String getUrlImg_20() {
        return urlImg_20;
    }

    public void setUrlImg_20(String urlImg_20) {
        this.urlImg_20 = urlImg_20;
    }

    public String getUrlImg_21() {
        return urlImg_21;
    }

    public void setUrlImg_21(String urlImg_21) {
        this.urlImg_21 = urlImg_21;
    }

    public String getUrlImg_22() {
        return urlImg_22;
    }

    public void setUrlImg_22(String urlImg_22) {
        this.urlImg_22 = urlImg_22;
    }

    public String getUrlImg_23() {
        return urlImg_23;
    }

    public void setUrlImg_23(String urlImg_23) {
        this.urlImg_23 = urlImg_23;
    }

    public String getUrlImg_24() {
        return urlImg_24;
    }

    public void setUrlImg_24(String urlImg_24) {
        this.urlImg_24 = urlImg_24;
    }

    public String getUrlImg_25() {
        return urlImg_25;
    }

    public void setUrlImg_25(String urlImg_25) {
        this.urlImg_25 = urlImg_25;
    }

    public String getUrlImg_26() {
        return urlImg_26;
    }

    public void setUrlImg_26(String urlImg_26) {
        this.urlImg_26 = urlImg_26;
    }

    public String getUrlImg_27() {
        return urlImg_27;
    }

    public void setUrlImg_27(String urlImg_27) {
        this.urlImg_27 = urlImg_27;
    }

    public String getUrlImg_28() {
        return urlImg_28;
    }

    public void setUrlImg_28(String urlImg_28) {
        this.urlImg_28 = urlImg_28;
    }

    public String getUrlImg_29() {
        return urlImg_29;
    }

    public void setUrlImg_29(String urlImg_29) {
        this.urlImg_29 = urlImg_29;
    }

    public String getUrlImg_30() {
        return urlImg_30;
    }

    public void setUrlImg_30(String urlImg_30) {
        this.urlImg_30 = urlImg_30;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontagemSoft that = (MontagemSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
