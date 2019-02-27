# LxViewLibs（QQ群：633600411）

#### 等等，还没完哦，陆续维护中............

# BaseMvp

新建activity继承BaseMvpAc,重写接口请求方法，示例：

```JAVA
public class LoginAc extends BaseMvpAc {

    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化view
     */
    @Override
    protected void initViews() {

    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginPresenter.login();
    }

    /**


* [模仿微信拖拽放大缩小图片](#模仿微信拖拽放大缩小图片)

# 模仿微信拖拽放大缩小图片
### activity:DragViewAc

![output1.gif](https://upload-images.jianshu.io/upload_images/4906229-d2d7c1290207cd11.gif?imageMogr2/auto-orient/strip)








