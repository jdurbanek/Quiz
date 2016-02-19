package com.example.josh.quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "answerOne";
    private static final String ARG_PARAM2 = "answerTwo";
    private static final String ARG_PARAM3 = "answerThree";
    private static final String ARG_PARAM4 = "answerFour";

    private int points = 0;
    private String imageQ = "Question Wrong";
    // TODO: Rename and change types of parameters
    private String answer1;
    private String answer2;
    private String answer3;
  //  private String answer4;

    private TextView question;
    private CheckBox checkBoxOne;
    private CheckBox checkBoxTwo;
    private CheckBox checkBoxThree;
  //  private Button submit;

    //4 texted based quesitons
    private String [] questions = {"Who was the third U.S President?", "Who has won the most Gold medals " +
            "at the Olympics?", "When was the University of Wisconsin-Madison established?", "How many people" +
            "signed the Constitution of the United States?"};

    private String [][] answers = {{"Thomas Jefferson", "James Madison", "Andrew Jackson"},
            {"Mark Spitz", "Michael Phelps", "Ray Ewry"},{"1940", "1890", "1848"},{"30", "45","39"}};



    private OnFragmentInteractionListener mListener;

    public PlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param answer1 Parameter 1.
     * @param answer2 Parameter 2.
     * @param answer3 Parameter 3.
     * @return A new instance of fragment PlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayFragment newInstance(String answer1, String answer2, String answer3,
                                           String imageQ) {
        PlayFragment fragment = new PlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, answer1);
        args.putString(ARG_PARAM2, answer2);
        args.putString(ARG_PARAM3, answer3);
        args.putString(ARG_PARAM4, imageQ);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            answer1 = getArguments().getString(ARG_PARAM1);
            answer2 = getArguments().getString(ARG_PARAM2);
            answer3 = getArguments().getString(ARG_PARAM3);
            imageQ = getArguments().getString(ARG_PARAM4);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);

        //set the widgets
        checkBoxOne = (CheckBox)view.findViewById(R.id.checkBox);
        checkBoxTwo = (CheckBox)view.findViewById(R.id.checkBox2);
        checkBoxThree = (CheckBox)view.findViewById(R.id.checkBox3);
      //  submit = (Button)view.findViewById(R.id.button2);
        question = (TextView)view.findViewById(R.id.textView3);
        //set the checkboxes to display the possible answers.
        //checkBoxOne.setText("testing");

        if(answer1 == null){
            question.setText(questions[0]);
            checkBoxOne.setText(answers[0][0]);
            checkBoxTwo.setText(answers[0][1]);
            checkBoxThree.setText(answers[0][2]);
        }else if(answer2 == null){
            question.setText(questions[1]);
            checkBoxOne.setText(answers[1][0]);
            checkBoxTwo.setText(answers[1][1]);
            checkBoxThree.setText(answers[1][2]);
        }else {
            question.setText(questions[2]);
            checkBoxOne.setText(answers[2][0]);
            checkBoxTwo.setText(answers[2][1]);
            checkBoxThree.setText(answers[2][2]);
        }



        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TA Implementation

        //different way of implementing click interaction.
        checkBoxOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answers[0][0], null, null, imageQ))
                            .commit();
                } else if (answer2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answer1, answers[0][1], null, imageQ))
                            .commit();
                } else {
                    answer3 = answers[0][2];
                    determinePoints();
                }
            }
        });

        checkBoxTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answers[1][0], null, null,imageQ))
                            .commit();
                } else if (answer2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answer1, answers[1][1], null, imageQ))
                            .commit();
                } else {
                    answer3 = answers[1][2];
                    determinePoints();
                }
            }
        });

        checkBoxThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answers[2][0], null, null, imageQ))
                            .commit();
                } else if (answer2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(answer1, answers[2][1], null, imageQ))
                            .commit();
                } else {
                    answer3 = answers[2][2];
                    determinePoints();
                }
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void determinePoints() {
        if(answer1.equals("Thomas Jefferson")){
            points++;
        }
        if(answer2.equals("Michael Phelps")) {
            points++;
        }
        if(answer3.equals("1848")) {
            points++;
        }
        if(imageQ.equals("Mt. Everest") || imageQ.equals("Everest")) {
            points++;
        }

        String score = "You got " + points + " of 4 questions correct.";
        displayWinner(score);

    }

    private void displayWinner(String score){

        //do a prompt about the winner
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Results")
                .setMessage(score)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //pop back 3 to get to first question, initial fragment on stack
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();

                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .show();

    }
}
