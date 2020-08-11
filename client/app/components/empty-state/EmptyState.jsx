import { keys, some } from "lodash";
import React from "react";
import PropTypes from "prop-types";
import classNames from "classnames";
import CreateDashboardDialog from "@/components/dashboards/CreateDashboardDialog";
import { currentUser } from "@/services/auth";
import organizationStatus from "@/services/organizationStatus";
import "./empty-state.less";

function Step({ show, completed, text, url, urlText, onClick }) {
  if (!show) {
    return null;
  }

  return (
    <li className={classNames({ done: completed })}>
      <a href={url} onClick={onClick}>
        {urlText}
      </a>{" "}
      {text}
    </li>
  );
}

Step.propTypes = {
  show: PropTypes.bool.isRequired,
  completed: PropTypes.bool.isRequired,
  text: PropTypes.string.isRequired,
  url: PropTypes.string,
  urlText: PropTypes.string,
  onClick: PropTypes.func,
};

Step.defaultProps = {
  url: null,
  urlText: null,
  onClick: null,
};

function EmptyState({
  icon,
  header,
  description,
  illustration,
  helpLink,
  onboardingMode,
  showAlertStep,
  showDashboardStep,
  showInviteStep,
}) {
  const isAvailable = {
    dataSource: true,
    query: true,
    alert: showAlertStep,
    dashboard: showDashboardStep,
    inviteUsers: showInviteStep,
  };

  const isCompleted = {
    dataSource: organizationStatus.objectCounters.data_sources > 0,
    query: organizationStatus.objectCounters.queries > 0,
    alert: organizationStatus.objectCounters.alerts > 0,
    dashboard: organizationStatus.objectCounters.dashboards > 0,
    inviteUsers: organizationStatus.objectCounters.users > 1,
  };

  // Show if `onboardingMode=false` or any requested step not completed
  const shouldShow = !onboardingMode || some(keys(isAvailable), step => isAvailable[step] && !isCompleted[step]);

  if (!shouldShow) {
    return null;
  }

  return (
    <div className="empty-state bg-white tiled">
      <div className="empty-state__summary">
        {header && <h4>{header}</h4>}
        <h2>
          <i className={icon} />
        </h2>
        <p>{description}</p>
        <img
          src={"/static/images/illustrations/" + illustration + ".svg"}
          alt={illustration + " Illustration"}
          width="75%"
        />
      </div>
      <div className="empty-state__steps">
        <h4>开始设置</h4>
        <ol>
          {currentUser.isAdmin && (
            <Step
              show={isAvailable.dataSource}
              completed={isCompleted.dataSource}
              url="data_sources/new"
              urlText="连接"
              text="数据源"
            />
          )}
          {!currentUser.isAdmin && (
            <Step
              show={isAvailable.dataSource}
              completed={isCompleted.dataSource}
              text="Ask an account admin to connect a data source"
            />
          )}
          <Step
            show={isAvailable.query}
            completed={isCompleted.query}
            url="queries/new"
            urlText="创建"
            text="你的第一个查询"
          />
          <Step
            show={isAvailable.alert}
            completed={isCompleted.alert}
            url="alerts/new"
            urlText="创建"
            text="你的第一个报警"
          />
          <Step
            show={isAvailable.dashboard}
            completed={isCompleted.dashboard}
            onClick={() => CreateDashboardDialog.showModal()}
            urlText="创建"
            text="你的第一个仪表盘"
          />
          <Step
            show={isAvailable.inviteUsers}
            completed={isCompleted.inviteUsers}
            url="users/new"
            urlText="邀请"
            text="你的团队成员"
          />
        </ol>
        <p>
          需要更多的支持?{" "}
          <a href={helpLink} target="_blank" rel="noopener noreferrer">
            查看帮助文档
            <i className="fa fa-external-link m-l-5" aria-hidden="true" />
          </a>
        </p>
      </div>
    </div>
  );
}

EmptyState.propTypes = {
  icon: PropTypes.string,
  header: PropTypes.string,
  description: PropTypes.string.isRequired,
  illustration: PropTypes.string.isRequired,
  helpLink: PropTypes.string.isRequired,

  onboardingMode: PropTypes.bool,
  showAlertStep: PropTypes.bool,
  showDashboardStep: PropTypes.bool,
  showInviteStep: PropTypes.bool,
};

EmptyState.defaultProps = {
  icon: null,
  header: null,

  onboardingMode: false,
  showAlertStep: false,
  showDashboardStep: false,
  showInviteStep: false,
};

export default EmptyState;
