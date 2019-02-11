define("nowcoder/1.2.1176/javascripts/site/login/forgotPwd",["nc","cpn","ncpc","../../action/login","../../action/profile"],function(i,t,n){var c=i("nc"),a=i("cpn"),e=i("ncpc"),s=c.$,r=c.Sys,o=c.Base,p=c.Str,v=c.Uri,u=c.Limit,h=a.Input,l=a.Popup,f=e.LoginUtil,m=i("../../action/login");i("../../action/profile");r.ready({initialize:function d(){var i=this;i.isOversea="oversea"===v.getParam("ltype"),i.initCpn(),i.initCaptcha(),i.initSubmit(),i.initTips()},initCpn:function P(){var i=this.cpn={};this.isOversea&&(i.zip=f.initPhoneZip({renderTo:s(".js-country")}));i.account=h.transform(s(".js-account")),i.captcha=h.transform(s(".js-captcha"))},initCaptcha:function g(){var n=this,i=n.cpn;f.initCaptcha({btn:s(".js-btn-captcha"),isPhone:function(){return n.isPhone()},check:function(i){var t=n.check(!0);i&&i(t)},val:function(){n.isPhone();return s.trim(i.zip?i.zip.val():"")+s.trim(i.account.val())}})},initSubmit:function k(){var n=this,c=n.cpn,a=s(".js-submit");a.on("click",function(i){if(i.preventDefault(),n.check()&&!u.mark(a)){var t=n.isPhone();m[t?"activeResetPhone":"activeResetEmail"]({body:n.val(),call:function(i){var t=i.data||{},n=o.isString(t)?t:t.ticket;window.location.href="/reset-pwd?ticket="+n},error:function(i){var t=i.msg||"";-1!==t.indexOf("验证码")?c.captcha.setErrorTips(i.msg):c.account.setErrorTips(i.msg)},always:function(){u.clear(a)}})}})},initTips:function z(){s(".js-code-tips").on("click",function(){new l({title:"收不到验证码？",content:['<div style="font-size:14px;">','<div style="margin-bottom:20px;">如果通过手机接收验证码，请查看手机是否欠费、停机，手机号码是否填写正确。是否被软件阻拦。</div>',"<div>如果通过邮箱接收验证码，请尝试到广告邮件、订阅邮件、垃圾邮件等目录找找看。</div>","</div>"].join(""),ok:function(){}})})},val:function j(){var i=this.cpn,t=this.isPhone(),n={code:s.trim(i.captcha.val())};return n[t?"phone":"email"]=s.trim(i.zip?i.zip.val():"")+s.trim(i.account.val()),n},check:function y(i){var t=this,n=t.cpn,c=s.trim(n.zip?n.zip.val():""),a=s.trim(n.account.val()),e=t.isPhone(),r=!0;if(a||t.isOversea){var o="";e&&(o=(t.isOversea&&"+86"!==c?/^\d{3,}$/.test(a):p.isPhone(a))?"":"请输入正确的手机号码"),!e&&(o=p.isEmail(a)?"":"请输入正确的邮箱"),n.account[o?"setErrorTips":"setNone"](o),r=r&&!o}else n.account.setErrorTips("请输入正确的邮箱或手机号码"),r=!1;if(i)return r;s.trim(n.captcha.val())||(n.captcha.setErrorTips("验证码不能为空"),r=!1);return r},isPhone:function T(){var i=s.trim(this.cpn.account.val());return this.isOversea||/^\d+$/.test(i)}})});