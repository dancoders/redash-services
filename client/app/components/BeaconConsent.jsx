import React, { useState } from "react";
import Card from "antd/lib/card";
import Button from "antd/lib/button";
import Typography from "antd/lib/typography";
import { clientConfig } from "@/services/auth";
import HelpTrigger from "@/components/HelpTrigger";
import DynamicComponent from "@/components/DynamicComponent";
import OrgSettings from "@/services/organizationSettings";

const Text = Typography.Text;

function BeaconConsent() {
  const [hide, setHide] = useState(false);

  if (!clientConfig.showBeaconConsentMessage || hide) {
    return null;
  }

  const hideConsentCard = () => {
    clientConfig.showBeaconConsentMessage = false;
    setHide(true);
  };

  const confirmConsent = confirm => {
    let message = "🙏 Thank you.";

    if (!confirm) {
      message = "Settings Saved.";
    }

    OrgSettings.save({ beacon_consent: confirm }, message)
      // .then(() => {
      //   // const settings = get(response, 'settings');
      //   // this.setState({ settings, formValues: { ...settings } });
      // })
      .finally(hideConsentCard);
  };

  return (
    <DynamicComponent name="BeaconConsent">
      <div className="m-t-10 tiled">
        <Card
          title={
            <>
              您是否同意与Redash团队共享匿名使用数据?{" "}
              <HelpTrigger type="USAGE_DATA_SHARING" />
            </>
          }
          bordered={false}>
          <Text>帮助Redash改善自动发送匿名使用数据:</Text>
          <div className="m-t-5">
            <ul>
              <li> 用户、查询、仪表板、警报、小部件和可视化的数量。.</li>
              <li> 数据源类型、警报目的地和可视化.</li>
            </ul>
          </div>
          <Text>所有数据都是聚合的，不会包含任何敏感或私有数据.</Text>
          <div className="m-t-5">
            <Button type="primary" className="m-r-5" onClick={() => confirmConsent(true)}>
              确定
            </Button>
            <Button type="default" onClick={() => confirmConsent(false)}>
              不要
            </Button>
          </div>
          <div className="m-t-15">
            <Text type="secondary">
              您可以随时更改此设置 <a href="settings/organization">组织设置</a>{" "}
              页.
            </Text>
          </div>
        </Card>
      </div>
    </DynamicComponent>
  );
}

export default BeaconConsent;
