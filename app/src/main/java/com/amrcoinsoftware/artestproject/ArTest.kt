package com.amrcoinsoftware.artestproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.amrcoinsoftware.artestproject.databinding.FragmentFloatUIBinding
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment

class ArTest : ArFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            var anchorNode = AnchorNode(hitResult.createAnchor())

            ModelRenderable.builder()

            ViewRenderable.builder()
                .setView(this.context, R.layout.fragment_float_u_i)
                .build()
                .thenAccept {
                    anchorNode.renderable = it
                    var button = it.view.findViewById<Button>(R.id.button_1)
                    button.text = "clickeame"
                    button.setOnClickListener {
                        button.text = "hmmmmm, si!"
                    }
                }
            arSceneView.scene.addChild(anchorNode)
            anchorNode.localPosition = Vector3(anchorNode.localPosition.x, 100f, anchorNode.localPosition.y)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}