package ictgradschool.individualProject.swingclient.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import ictgradschool.individualProject.swingclient.pojos.User;
import ictgradschool.individualProject.swingclient.pojos.UserQuery;
import ictgradschool.individualProject.swingclient.web.API;
import org.seamless.swing.BeanTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author anhyd
 */
public class EasyByteAdminApp extends javax.swing.JFrame {

    private JButton loginBtn, logoutBtn, deleteBtn;
    private JLabel currentUsername;
    private JLabel isAdmin;
    private JTextField username;
    private JPasswordField password;
    private JTable userDetails;
    private JLabel errorMessage;
    private BeanTableModel<User> dataModel = new BeanTableModel<User>(User.class);
    private JScrollPane jScrollPane1;
    private User user;
    private User selectedUser;

    /**
     * Creates new form PokemonApp
     */
    public EasyByteAdminApp() {


        initComponents();

        loginBtn.addActionListener(this::handleBtnChangeClick);
        logoutBtn.addActionListener(this::handleLogoutBtnChangeClick);
        deleteBtn.addActionListener(this::handleDeleteUser);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        dataModel.resetColumns();
        dataModel.addColumn("Username", "username");
        dataModel.addColumn("First Name", "fname");
        dataModel.addColumn("Last Name", "lname");
        dataModel.addColumn("Birthday", "birthday");
        dataModel.addColumn("Description", "description");
        dataModel.addColumn("Recipe Count", "recipe_count");

        userDetails = new JTable(dataModel);
        username = new JTextField();
        password = new JPasswordField();
        errorMessage = new javax.swing.JLabel();
        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        errorMessage.setForeground(Color.red);

        JLabel userNameLabel = new javax.swing.JLabel();
        JLabel passwordLabel = new javax.swing.JLabel();
        userNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        userNameLabel.setText("username:");
        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        passwordLabel.setText("password:");
        loginBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        loginBtn.setText("Log in");
        logoutBtn.setText("Log out");
        deleteBtn.setText("Delete");
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        currentUsername = new javax.swing.JLabel();
        isAdmin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("User name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Admin or not:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("User Details:");

        currentUsername.setText("Username goes here");

        isAdmin.setText("Admin or not goes here");
        logoutBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        userDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        userDetails.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        if (userDetails.getSelectedRow() != -1) {
                            deleteBtn.setEnabled(true);
                            selectedUser = dataModel.getRows().get(userDetails.getSelectedRow());
                        }
                    }
                }
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jScrollPane1.setViewportView(userDetails);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                                )
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(currentUsername)
                                                                                        .addComponent(isAdmin))
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(logoutBtn))
                                                                        )
                                                                        .addComponent(jLabel3))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(deleteBtn)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(currentUsername)
                                                        .addComponent(logoutBtn)
                                                )
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(isAdmin))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(userNameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(loginBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        )
                                )
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn)
                                .addContainerGap())
        );

        pack();
    }

    private void handleBtnChangeClick(ActionEvent e) {
        new UserLogin().execute();
    }

    private void handleLogoutBtnChangeClick(ActionEvent e) {
        new UserLogout().execute();
    }

    private void handleDeleteUser(ActionEvent e) {
        new DeleteUser(selectedUser.getUserId()).execute();
    }



    private class UserLogin extends SwingWorker<Integer, Void> {
        private final String usernameValue;
        private final String passwordValue;


        public UserLogin() {
            logoutBtn.setEnabled(false);
            loginBtn.setEnabled(false);
            username.setEnabled(false);
            password.setEnabled(false);
            deleteBtn.setEnabled(false);
            this.usernameValue = username.getText();
            this.passwordValue = String.valueOf(password.getPassword());

        }

        @Override
        protected Integer doInBackground() throws Exception {
            return API.getInstance().logIn(new UserQuery(usernameValue, passwordValue));
        }

        @Override
        protected void done() {
            try {
                int result = get();
                if (result == 204) {
                    new GetUser().execute();
                } else {
                    deleteBtn.setEnabled(false);
                    logoutBtn.setEnabled(false);
                    loginBtn.setEnabled(true);
                    username.setEnabled(true);
                    password.setEnabled(true);
                    errorMessage.setText("Login Failed");
                }
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
        }
    }

    private class UserLogout extends SwingWorker<Integer, Void> {


        public UserLogout() {
            logoutBtn.setEnabled(false);
        }

        @Override
        protected Integer doInBackground() throws Exception {
            return API.getInstance().logOut();
        }

        @Override
        protected void done() {
            try {
                int result = get();
                if (result == 204) {
                    logoutBtn.setEnabled(false);
                    dataModel.setRows(new ArrayList<>());
                    userDetails.setModel(dataModel);
                    loginBtn.setEnabled(true);
                    username.setEnabled(true);
                    password.setEnabled(true);
                    currentUsername.setText("Username goes here");
                    isAdmin.setText("Admin or not goes here");

                } else {
                    logoutBtn.setEnabled(true);
                    errorMessage.setText("Logout Failed");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private class GetUsers extends SwingWorker<List<User>, Void> {


        public GetUsers() {
        }

        @Override
        protected List<User> doInBackground() throws Exception {
            return API.getInstance().getAllUsers();
        }

        @Override
        protected void done() {
            try {
                List<User> result = get();
                dataModel.setRows(result);
                userDetails.setModel(dataModel);
                jScrollPane1.setViewportView(userDetails);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private class GetUser extends SwingWorker<User, Void> {


        public GetUser() {

        }

        @Override
        protected User doInBackground() throws Exception {
            return API.getInstance().getCurrentUser();
        }

        private void handleGetUsers() {
            new GetUsers().execute();
        }

        @Override
        protected void done() {
            try {
                user = get();
                if (user.getIsAdmin() == null || !user.getIsAdmin().equals("1")) {
                    new UserLogout().execute();
                    errorMessage.setText("Not authenticated as admin");
                } else {
                    currentUsername.setText(user.getUsername());
                    isAdmin.setText(String.valueOf(user.getIsAdmin().equals("1")));
                    this.handleGetUsers();
                    logoutBtn.setEnabled(true);
                    errorMessage.setText("");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private class DeleteUser extends SwingWorker<Integer, Void> {
        private int userId;


        public DeleteUser(int userId) {
            deleteBtn.setEnabled(false);
            this.userId = userId;
        }

        @Override
        protected Integer doInBackground() throws Exception {
            return API.getInstance().DeleteUser(this.userId);
        }


        @Override
        protected void done() {
            try {
                int result = get();
                if (result == 204) {
                    new GetUsers().execute();
                } else {

                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
